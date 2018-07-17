package jp.co.sss.sample.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.sample.bean.Account;
import jp.co.sss.sample.util.DBManager;

/**
 * 検索機能のクラス
 *
 * @author System Shared
 */
@WebServlet(urlPatterns = { "/select_not_used_dao" })
public class Select01Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {

            // DBに接続F
            connection = DBManager.getConnection();

            // SQL文を準備
            String sql = "SELECT * FROM account";

            // ステートメントを作成
            preparedStatement = connection.prepareStatement(sql);

            // SQL文を実行
            resultSet = preparedStatement.executeQuery();

            // 検索したレコードをAccountクラスのオブジェクトに格納
            List<Account> list = new ArrayList<Account>();
            while (resultSet.next()) {
                Account account = new Account();
                account.setId(resultSet.getInt("id"));
                account.setName(resultSet.getString("name"));
                account.setMoney(resultSet.getInt("money"));

                list.add(account);
            }

            // リクエストスコープに検索結果を保存
            request.setAttribute("list", list);

            // 検索結果画面に遷移
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/result/select_result.jsp");
            dispatcher.forward(request, response);

        } catch (Exception e) {
            PrintWriter out = response.getWriter();
            out.println("System Error");
        } finally {
            // ResultSetをクローズ
            DBManager.close(resultSet);

            // PreparedStatementをクローズ
            DBManager.close(preparedStatement);

            // DBとの接続を切断
            DBManager.close(connection);
        }
    }
}
