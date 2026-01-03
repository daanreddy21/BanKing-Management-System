package com.bank.servlet;

import java.sql.*;
import java.util.*;

public class TransactionDAO {

    public List<TransactionDTO> getTransactions(String accountId)
            throws SQLException, ClassNotFoundException {

        List<TransactionDTO> list = new ArrayList<>();
        String sql =
          "SELECT * FROM transactions WHERE account_id=? ORDER BY txn_date DESC";

        try (Connection con = DBconnection.getconnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, accountId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                TransactionDTO t = new TransactionDTO();
                t.setType(rs.getString("type"));
                t.setAmount(rs.getDouble("amount"));
                t.setBalanceAfter(rs.getDouble("balance_after"));
                t.setTxnDate(rs.getTimestamp("txn_date"));
                list.add(t);
            }
        }
        return list;
    }
}
