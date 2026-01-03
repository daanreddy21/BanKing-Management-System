<%@ page import="java.util.*" %>
<%@ page import="com.bank.servlet.TransactionDTO" %>
<%@ page session="true" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<!DOCTYPE html>
<html>
<head>
<title>Transaction History</title>

<style>
body { font-family: Arial; background:#f3f3f3; }
table {
    width:90%; margin:50px auto;
    border-collapse:collapse;
    background:#fff;
}
th, td {
    border:1px solid #ccc;
    padding:10px; text-align:center;
}
th { background:#1a73e8; color:white; }
.credit { color:green; font-weight:bold; }
.debit { color:red; font-weight:bold; }
</style>
</head>

<body>

<h2 style="text-align:center">Transaction History</h2>

<table>
<tr>
  <th>Date</th>
  <th>Type</th>
  <th>Amount</th>
  <th>Balance After</th>
</tr>

<%
List<TransactionDTO> list =
    (List<TransactionDTO>) request.getAttribute("transactions");

if (list != null && !list.isEmpty()) {
    for (TransactionDTO t : list) {
%>
<tr>
  <td><%= t.getTxnDate() %></td>
  <td class="<%= t.getType().equals("CREDIT") ? "credit" : "debit" %>">
      <%= t.getType() %>
  </td>
  <td>₹ <%= t.getAmount() %></td>
  <td>₹ <%= t.getBalanceAfter() %></td>
</tr>
<% } } else { %>
<tr><td colspan="4">No transactions found</td></tr>
<% } %>

</table>

<div style="text-align:center">
<a href="UserDash.jsp">Back to Dashboard</a>
</div>

</body>
</html>
