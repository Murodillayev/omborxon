package uz.pdp.omnborxona.servlet;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.omnborxona.model.dto.WarehouseDto;
import uz.pdp.omnborxona.service.WarehouseService;

import java.io.IOException;
import java.util.List;

@WebServlet("/warehouse")
public class WarehouseServlet extends HttpServlet {

    @Inject
    private WarehouseService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");


        if (action == null && req.getHttpServletMapping().getMatchValue() != null) {
            infoPage(req, resp);
        } else if ("add".equals(action)) {
            // todo add qilish pageni ochadigan qilish kerak
        } else if ("update".equals(action)) {
            // todo edit qilish pageni ochadigan qilish kerak
        } else {
            listPage(req, resp);
        }


    }

    private void infoPage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getHttpServletMapping().getMatchValue();
        WarehouseDto warehouse = service.get(id);
        req.setAttribute("warehouse", warehouse);
        resp.sendRedirect("/warehouse/info.jsp");
    }

    private void listPage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<WarehouseDto> warehouses = service.getAll();
        req.setAttribute("warehouses", warehouses);
        resp.sendRedirect("/warehouse/list.jsp");
    }

    private void updatePage(HttpServletRequest req, HttpServletResponse resp) {

    }

    private void addPage(HttpServletRequest req, HttpServletResponse resp) {

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
