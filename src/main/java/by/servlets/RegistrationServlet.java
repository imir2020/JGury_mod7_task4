package by.servlets;

import by.database.entity.Status;
import by.dto.CreateUserDto;
import by.utils.JspHelper;
import lombok.extern.slf4j.Slf4j;
import by.service.UserService;

import java.io.IOException;

@Slf4j
//@WebServlet("/registration")
public class RegistrationServlet  {//extends HttpServlet
//    private final UserService userService = UserService.getInstance();
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setAttribute("status", Status.values());
//        req.getRequestDispatcher(JspHelper.getPath("registration")).forward(req, resp);
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
//        var userDto = CreateUserDto.builder()
//                .name(req.getParameter("name"))
//                .birthday(req.getParameter("birthday"))
//                .password(req.getParameter("pwd"))
//                .status(req.getParameter("status"))
//                .build();
//
//        try {
//            userService.create(userDto);
//            log.info("The User with name {} and status {} was registered", userDto.getName(), userDto.getStatus());
//            resp.sendRedirect("/login");
//        } catch (ValidationException e) {
//            req.setAttribute("errors", e.getErrors());
//            doGet(req,resp);
//        }
//    }
}
