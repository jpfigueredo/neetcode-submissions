class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String unit: tokens){
            if(unit.equals("+")){
                stack.push(stack.pop() + stack.pop());
            }else if(unit.equals("-")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b-a);
            }else if(unit.equals("*")){
                stack.push(stack.pop() * stack.pop());
            }else if(unit.equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b/a);
            } else{
                stack.push(Integer.parseInt(unit));
            }
        }
        return stack.pop();
    }
}
