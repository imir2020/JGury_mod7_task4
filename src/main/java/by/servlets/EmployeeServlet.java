package by.servlets;

//@WebServlet("/employees")
public class EmployeeServlet  {//extends HttpServlet
//    private final EmployeeService employeeService = EmployeeService.getInstance();
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setAttribute("allEmployees", employeeService.findAll());
//        req.getRequestDispatcher(JspHelper.getPath("employees")).forward(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        var employeeDto = ToBaseEmployeeDto.builder()
//                .lastName(req.getParameter("lastName"))
//                .name(req.getParameter("name"))
//                .middleName(req.getParameter("middleName"))
//                .dateBirth(req.getParameter("dateBirth"))
//                .phoneNumber(req.getParameter("phoneNumber"))
//                .address(req.getParameter("address"))
//                .rankId(Long.valueOf(req.getParameter("rankId")))
//                .build();
//
//        try {
//            employeeService.saveEmployee(employeeDto);
//            resp.sendRedirect("/employees");
//        } catch (ValidationException e) {
//            req.setAttribute("errors", e.getErrors());
//            doGet(req,resp);
//        }
//
//    }
}
