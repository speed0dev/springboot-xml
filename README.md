# springboot-xml
sprinb boot xml param


xml 파싱 처리부분 개선 할것



https://ohju.tistory.com/369




code


@WebServlet(name = "RequestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        System.out.println("messageBody = " + messageBody);

        response.getWriter().write("ok");

    }
}
inputStream은 byte 코드를 반환하기 때문에 문자표(UTF-8로 설정)를 지정해 줘야 한다.

먼저 간단한 TEXT 메시지를 HTTP 메시지 바디에 담아서 전송을 해본다.
