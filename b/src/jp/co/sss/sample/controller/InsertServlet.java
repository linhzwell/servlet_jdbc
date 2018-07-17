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
 * 登録機能のクラス
 *
 * @author System Shared
 */
@WebServlet(urlPatterns = { "/insert" })
public class InsertServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 入力値をAccountクラスのオブジェクトに保存
        Account account = new Account();
        account.setId(Integer.parseInt(request.getParameter("id")));
        account.setName(request.getParameter("name"));
        account.setMoney(Integer.parseInt(request.getParameter("money")));

        try {
            // AccountDaoから登録用メソッドを呼出
            AccountDao.insert(account);

            // 登録結果画面に遷移
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/result/insert_result.jsp");
            dispatcher.forward(request, response);

        } catch (Exception e) {
            PrintWriter out = response.getWriter();
            out.println("System Error");
        }
    }
}
