package jp.co.sss.sample.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.sample.bean.Account;
import jp.co.sss.sample.dao.AccountDao;

/**
 * 削除機能のクラス
 *
 * @author System Shared
 */
@WebServlet(urlPatterns = { "/delete" })
public class DeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 入力値をAccountクラスのオブジェクトに保存
        Account account = new Account();
        account.setId(Integer.parseInt(request.getParameter("id")));

        try {
            // AccountDaoから更新用メソッドを呼出
            AccountDao.delete(account);

            // 更新結果画面に遷移
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/result/delete_result.jsp");
            dispatcher.forward(request, response);

        } catch (Exception e) {
            PrintWriter out = response.getWriter();
            out.println("System Error");
        }
    }
}
