package calculator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Calculator_1")
public class Calculator_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>My Calculator</title>");
		out.println("</head>");

		out.println("<body>");
		out.println("<h1>Calculator</h1>");

		out.println("<form>");

		out.println("<label for='number_x'>Number X: </label>");
		out.println("<input type='text' name='number_x'/><br/>");

		out.println("<label for='number_y'>Number Y: </label>");
		out.println("<input type='text' name='number_y'/></br/>");

		out.println("<label for='action'>What would you want to do?  </label>");
		out.println("<select name='action'>");
		out.println("<option value='+'>+</option>");
		out.println("<option value='-'>-</option>");
		out.println("<option value='*'>x</option>");
		out.println("<option value='/'>÷</option>");

		out.println("</select><br/>");
		out.println("<button>Calculate</button>");

		out.println("</form>");

		String parameter_x = request.getParameter("number_x");
		String parameter_y = request.getParameter("number_y");
		String action = request.getParameter("action");

		if (parameter_x != null && parameter_y != null && action != null) {

			try {

				int x = Integer.parseInt(parameter_x);
				int y = Integer.parseInt(parameter_y);
				int calculateResult = CalculatorLogic.calculate(x, y, action);

				out.printf("<p>%d %s %d = <strong>%d</strong></p>", x, action, y, calculateResult);

			} catch (NumberFormatException e) {
				out.println("Incorrect numbers format: " + e.getMessage());
			}

			out.println("</body>");
			out.println("</html>");

		}

		out.println("<a href=index.html>Back to Contents</a>");

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
