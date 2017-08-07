import java.util.Stack;

public class CalculatorParsing {

	// parsing해야해
	public void StringParsing(String str) {

		// parsing 할 결과를 저장할 곳
		String result = null;
		
		//전체적인 식을 저장하기 위한 스택
		Stack<String> cal = new Stack();
		
		//부호 저장을 위한 스택
		Stack<String> sign = new Stack();
		
		// parsing할때 부호이면 switch문에서 굴러가고
		// 아니면 스트링에 들어가게
		String calculus = null;
		
		// 공백 제거
		str = str.trim();
		String s = "";

		for (int i = 0; i < str.length(); i++) {
			switch (str.charAt(i)) {
			case '+':
			case '-':
				//숫자들도 stack에 저장해줘야해
				cal.push(calculus);
				//부호를 저장하는 스택이 비어있는 경우라면 부호를 그냥 저장해주면 되는거지
				if(sign.isEmpty())
					sign.push(""+str.charAt(i));
				//부호를 저장하는 스택이 비어있지 않고, 그 스택에 있는게 괄호가 아니라면 sign을 모두 cal stack에 저장해줘야해
				else if(sign.peek() == "(")
					sign.push(""+str.charAt(i));
				else
					cal.push(sign.pop());
					
				
			case '*':
			case '/':
				//부호가 나왔으니까 여태까지 저장해둔 숫자는 모두 stack에 저장해야지
				cal.push(calculus);
				//그리고 부호를 일단 저장해! --> 부호에 우선순위를 잊지말고!
				if(sign.peek() == "*" || sign.peek() == "/")
				{
					while(sign.isEmpty())
						cal.push(sign.pop());
				}
				break;
			case '(' :
				
				break;
			case ')' :
				while(cal.pop() == "(")
				{
					//no
				}
				
			default: // calculus.concat((str.charAt(i)).toString());
				calculus = calculus + str.charAt(i);
				break;

			}
		}

	}

}
