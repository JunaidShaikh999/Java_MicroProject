package com.auction.servlet;

import com.auction.dao.AuctionDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/PlaceBidServlet")
public class PlaceBidServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AuctionDAO auctionDAO = new AuctionDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        
        if (session == null || session.getAttribute("userId") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        try {
            int userId = (Integer) session.getAttribute("userId");
            int itemId = Integer.parseInt(request.getParameter("itemId"));
            double bidAmount = Double.parseDouble(request.getParameter("bidAmount"));

            boolean success = auctionDAO.placeBid(userId, itemId, bidAmount);

            if (success) {
                response.sendRedirect("dashboard.jsp?msg=Bid placed successfully!");
            } else {
                response.sendRedirect("dashboard.jsp?error=Bid must be higher than current highest bid!");
            }
        } catch (NumberFormatException e) {
            response.sendRedirect("dashboard.jsp?error=Invalid input data!");
        }
    }
}
