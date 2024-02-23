package by.servlets;

import by.utils.JspHelper;
import by.service.CategoryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Component
@WebServlet("/categories")
public class CategoryServlet  extends HttpServlet {
    private final CategoryService categoryService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        var categories = categoryService.findAll();
        req.setAttribute("categories", categories);
        req.getRequestDispatcher(JspHelper.getPath("categories")).forward(req, resp);
        log.info("The request was directed in 'categories' page");
    }
}
