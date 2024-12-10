import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class BoundedStackTest {
    @Test
    public void testSize() {
        BoundedStack<Integer> stack = new BoundedStack<>(3);
        assertEquals(0, stack.size());

        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.size());
        assertEquals(1, stack.getPushStatus());

        stack.pop();
        assertEquals(2, stack.size());

        stack.pop();
        stack.pop();
        assertEquals(0, stack.size());

        stack.pop();
        assertEquals(2, stack.getPopStatus());
    }

    @Test
    public void testPop() {
        BoundedStack<String> stack = new BoundedStack<>(3);

        stack.push("a");
        stack.push("b");
        stack.push("c");

        stack.pop();
        assertEquals(1, stack.getPopStatus());
        stack.pop();
        assertEquals(1, stack.getPopStatus());
        stack.pop();
        assertEquals(1, stack.getPopStatus());

        stack.pop();
        assertEquals(2, stack.getPopStatus());
    }

    @Test
    public void testPush() {
        BoundedStack<Double> stack = new BoundedStack<>(3);
        stack.push(3.14);
        assertEquals(1, stack.size());
        assertEquals(3.14, stack.peek(), 0.001);

        stack.push(2.718);
        assertEquals(2, stack.size());
        assertEquals(2.718, stack.peek(), 0.001);

        stack.push(4.8);
        assertEquals(1, stack.getPushStatus());

        stack.push(8.99);
        assertEquals(2, stack.getPushStatus());

        assertEquals(3, stack.size());
    }

    @Test
    public void testPeek() {
        BoundedStack<Character> stack = new BoundedStack<>(3);
        assertNull(stack.peek());

        stack.push('a');
        assertEquals('a', stack.peek().charValue());

        stack.push('b');
        assertEquals('b', stack.peek().charValue());

        stack.pop();
        assertEquals('a', stack.peek().charValue());

        assertEquals(1, stack.getPeekStatus());

        stack.pop();
        stack.peek();
        assertEquals(2, stack.getPeekStatus());
    }

    @Test
    public void testClear() {
        BoundedStack<Integer> stack = new BoundedStack<>(3);
        assertEquals(0, stack.size());

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.size());
        assertEquals(1, stack.getPushStatus());
        assertEquals(0, stack.getPeekStatus());
        assertEquals(0, stack.getPopStatus());

        stack.clear();
        assertEquals(0, stack.size());
        assertEquals(0, stack.getPushStatus());
        assertEquals(0, stack.getPeekStatus());
        assertEquals(0, stack.getPopStatus());
    }
}
