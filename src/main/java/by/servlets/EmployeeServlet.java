package by.servlets;

import by.database.entity.Rank;
import by.database.repository.Greid;
import by.dto.employees_dto.FromEmployeeDtoToBase;
import by.service.EmployeeService;
import by.utils.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;


@Slf4j
@RequiredArgsConstructor
@Component
@WebServlet("/employees")
public class EmployeeServlet  extends HttpServlet {
    private final EmployeeService employeeService ;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("allEmployees", employeeService.findAll());
        req.getRequestDispatcher(JspHelper.getPath("employees")).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var employeeDto = FromEmployeeDtoToBase.builder()
                .lastName(req.getParameter("lastName"))
                .name(req.getParameter("name"))
                .middleName(req.getParameter("middleName"))
                .dateBirth(LocalDate.parse(req.getParameter("dateBirth")))
                .phoneNumber(req.getParameter("phoneNumber"))
                .address(req.getParameter("address"))
                .rank(Rank.builder()
                        .rankName(Greid.valueOf(req.getParameter("rankId")))
                        .build())
                .build();

        try {
            employeeService.save(employeeDto);
            log.info("The object FromEmployeeDtoToBase was saved in method doPost(): {}" + employeeDto);
            resp.sendRedirect("/employees");
        } catch (Exception e) {
            req.setAttribute("errors", e.getMessage());
            doGet(req,resp);
        }
    }
}
