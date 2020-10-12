package calculator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Calculator_2")
public class Calculator_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = SetHeadersAndGetWriter(response);
		start(out);
		form(out);
		end(out);
		back(out);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = SetHeadersAndGetWriter(response);
		start(out);
		form(out);
		handleParametersAndShowResutls(request, out);
		end(out);
		back(out);
	}

	private PrintWriter SetHeadersAndGetWriter(HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		return out;
	}

	private void start(PrintWriter out) {
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Calculator 2</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Calculator 2 - new logic</h1>");
	}
	
	private void end(PrintWriter out) {
		out.println("</body>");
		out.println("</html>");
	}

	private void form(PrintWriter out) {
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
	}

	private void handleParametersAndShowResutls(HttpServletRequest request, PrintWriter out) {
		String parameter_x = request.getParameter("number_x");
		String parameter_y = request.getParameter("number_y");
		String action = request.getParameter("action");

		try {
			int x = Integer.parseInt(parameter_x);
			int y = Integer.parseInt(parameter_y);
			int calculateResult = CalculatorLogic.calculate(x, y, action);
			out.printf("<p>%d %s %d = <strong>%d</strong></p>", x, action, y, calculateResult);

		} catch (NumberFormatException e) {
			out.println("Incorrect numbers format: " + e.getMessage());
		}

	}

	private void back(PrintWriter out) {
		out.println("<a href=index.html>Back to Contents</a>");

	}

}
