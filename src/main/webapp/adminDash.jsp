<%@ page import="java.util.*" %>
<%@ page import="com.bank.servlet.AccountRequestDTO" %>

<!DOCTYPE html>
<html>
<head>
<title>Admin Dashboard</title>

<style>
body {
    font-family: Arial;
    background:#e3f2fd;
    margin:0;
    padding:0;
}

h2 {
    text-align:center;
    margin-top:20px;
}

.filter-box {
    text-align:center;
    margin:20px 0;
}

.filter-box a {
    margin:0 10px;
    text-decoration:none;
}

.filter-box button {
    padding:8px 16px;
    border:none;
    border-radius:5px;
    background:#1a73e8;
    color:white;
    cursor:pointer;
}

table {
    width:95%;
    margin:20px auto;
    border-collapse:collapse;
    background:#fff;
}

th, td {
    padding:10px;
    border:1px solid #ccc;
    text-align:center;
}

th {
    background:#1a73e8;
    color:white;
}

.pending {
    color:orange;
    font-weight:bold;
}

.approved {
    color:green;
    font-weight:bold;
}

.rejected {
    color:red;
    font-weight:bold;
}

.action-form {
    display:inline;
}

input[type="text"] {
    width:140px;
    padding:5px;
}

button.approve {
    background:green;
    color:white;
    border:none;
    padding:6px 10px;
}

button.reject {
    background:red;
    color:white;
    border:none;
    padding:6px 10px;
}

button[disabled] {
    background:gray;
    cursor:not-allowed;
}
</style>
</head>

<body>

<h2>Admin Dashboard Account Requests</h2>

<!-- FILTER BUTTONS -->
<div class="filter-box">
    <a href="adminDash?status=PENDING">
        <button>Pending Requests</button>
    </a>

    <a href="adminDash?status=COMPLETED">
        <button>Completed Requests</button>
    </a>

    <a href="adminDash">
        <button>All Requests</button>
    </a>
</div>

<table>
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Aadhaar</th>
    <th>Phone</th>
    <th>Address</th>
    <th>Deposit</th>
    <th>Status</th>
    <th>Action</th>
</tr>

<%
List<AccountRequestDTO> list =
    (List<AccountRequestDTO>) request.getAttribute("requests");

if (list != null && !list.isEmpty()) {
    for (AccountRequestDTO dto : list) {
%>

<tr>
    <td><%= dto.getId() %></td>
    <td><%= dto.getName() %></td>
    <td><%= dto.getAadhaar() %></td>
    <td><%= dto.getPhone() %></td>
    <td><%= dto.getAddress() %></td>
    <td>₹ <%= dto.getDeposit() %></td>

    <td class="
        <%= "PENDING".equals(dto.getStatus()) ? "pending" :
            "APPROVED".equals(dto.getStatus()) ? "approved" : "rejected" %>">
        <%= dto.getStatus() %>
    </td>

    <td>
    <% if ("PENDING".equals(dto.getStatus())) { %>

        <!-- APPROVE -->
        <form class="action-form" action="createAccount" method="post">
            <input type="hidden" name="reqId" value="<%= dto.getId() %>">
            <button class="approve">Approve</button>
        </form>

        <!-- REJECT -->
        <form class="action-form" action="rejectAccount" method="post">
            <input type="hidden" name="reqId" value="<%= dto.getId() %>">
            <input type="text" name="reason" placeholder="Reason" required>
            <button class="reject">Reject</button>
        </form>

    <% } else if ("REJECTED".equals(dto.getStatus())) { %>

        <span class="rejected">Rejected</span><br>
        <small><%= dto.getRejectionReason() %></small>

    <% } else { %>

        <button disabled>Approved</button>

    <% } %>
    </td>
</tr>

<%
    }
} else {
%>

<tr>
    <td colspan="8">No account requests found</td>
</tr>

<%
}
%>

</table>

</body>
</html>
