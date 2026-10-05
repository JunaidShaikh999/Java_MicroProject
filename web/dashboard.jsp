<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Online Auction System - Live Dashboard</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; background-color: #f9f9f9; }
        h2 { color: #800000; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; background: #fff; }
        th, td { border: 1px solid #ccc; padding: 10px; text-align: left; }
        th { background-color: #800000; color: white; }
        .error { color: red; font-weight: bold; }
        .success { color: green; font-weight: bold; }
        .btn { background-color: #008CBA; color: white; padding: 6px 12px; border: none; cursor: pointer; }
    </style>
</head>
<body>
    <h2>Online Auction System - Live Dashboard</h2>

    <% if (request.getParameter("msg") != null) { %>
        <p class="success"><%= request.getParameter("msg") %></p>
    <% } %>
    <% if (request.getParameter("error") != null) { %>
        <p class="error"><%= request.getParameter("error") %></p>
    <% } %>

    <table>
        <thead>
            <tr>
                <th>Item ID</th>
                <th>Product Description</th>
                <th>Highest Bid</th>
                <th>Time Left</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>#1045</td>
                <td>Vintage Leather Motorcycle Jacket</td>
                <td>Rs 11,000.00</td>
                <td>02:15:30</td>
                <td>
                    <form action="PlaceBidServlet" method="POST">
                        <input type="hidden" name="itemId" value="1045">
                        <input type="number" step="100" name="bidAmount" placeholder="New Bid" required>
                        <button type="submit" class="btn">Place Bid</button>
                    </form>
                </td>
            </tr>
        </tbody>
    </table>
</body>
</html>
