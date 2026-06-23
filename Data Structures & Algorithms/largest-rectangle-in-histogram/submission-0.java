class Solution 
{
    /*
         What the Monotonic Increasing Stack Represents
You keep a stack of indices such that their heights are in increasing order.
Think of it like:

bars in the stack are not finalized yet
they might be able to extend further right
they stay in the stack until something smaller blocks them


🎯 When Do We Compute an Area?
The moment you see a bar curr that is smaller than the stack top
That smaller bar is a right wall.
So you start popping because:

any bar taller than curr cannot extend into curr
so its rectangle ends just before the current index

✅ Pop = finalize that bar’s maximum rectangle

🧱 Boundaries for a Popped Bar (This is the core)
When you pop an index mid while scanning at index i:
1) Right boundary (blocking)

Right boundary marker = i
because i is the first index to the right with height < height[mid]
so mid’s rectangle cannot include i
hence rightmost included = i - 1

2) Left boundary (blocking)
After popping mid:

Left boundary marker = stack.peek() (new top)
that’s the nearest index to the left with height < height[mid]
if stack is empty, left boundary marker is -1

3) Width
The rectangle spans:

from (left + 1) to (right - 1)

So:

width = right - left - 1

4) Area

area = height[mid] × width

And you keep maxArea.

🧯 Why We “Flush” at the End
After you finish scanning, some bars never found a smaller bar on the right.
So for those:

treat the right boundary marker as n (one past the last index)

Then pop remaining bars and compute areas using the same formula:

right = n
left = new stack top or -1

✅ This step is essential because the best rectangle might extend to the end.

🎥 Simple Picture in Your Head
Imagine each bar is trying to stretch rightwards to build a rectangle:

As long as heights are going up, everyone is happy → push onto stack.
The first time height drops:

it acts like a guillotine / wall
it forces all taller bars to stop
you compute their rectangles immediately.




✅ The Key Invariant to Remember

At any time, the stack is increasing.
This guarantees that when a bar is popped, the stack’s new top is the first smaller bar to its left, and the current index is the first smaller bar to its right.

That’s why the width formula always works.

🧩 Mini “boundary rule” you can memorize
When popping mid at scan index i:

right = i (blocking index)
left = stack.peek() after pop (blocking index) OR -1
width = right - left - 1
area = height[mid] * width


If you want, I can also give you a 30-second cheat sheet version (even shorter), or do one final dry run on {6,1,2,4,9} or {2,1,5,6,2,3} to cement it.
    
    */
    public int largestRectangleArea(int[] heights) 
    {
        int n = heights.length;
        Stack<Integer> stack = new Stack();
        int maxArea = 0;
        for(int i=0;i<n;i++)
        {
            int curr = heights[i];

            while(!stack.isEmpty() && heights[stack.peek()]>=curr )
            {
                int mid = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                int right = i;
                int width = right-left-1;
                int area = heights[mid]*width;
                maxArea = Math.max(maxArea,area);
            }
            stack.push(i);
        }

        while(!stack.isEmpty())
        {
            int mid = stack.pop();
            int right = n;
            int left = stack.isEmpty() ? -1 : stack.peek();
            int width = right-left-1;
            int area = heights[mid]*width;
            maxArea = Math.max(maxArea,area);
        }
        return maxArea;
    }
}