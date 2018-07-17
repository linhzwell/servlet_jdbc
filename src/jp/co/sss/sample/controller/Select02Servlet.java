package jp.co.sss.sample.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.sample.bean.Account;
import jp.co.sss.sample.dao.AccountDao;

/**
 * 検索機能のクラス
 *
 * @author System Shared
 */
@WebServlet(urlPatterns = { "/select" })
public class Select02Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // AccountDaoから検索用メソッドを呼出
            List<Account> list = AccountDao.selectAll();

            // リクエストスコープに検索結果を保存
            request.setAttribute("list", list);

            // 検索結果画面に遷移
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/result/select_result.jsp");
            dispatcher.forward(request, response);

        } catch (Exception e) {
            PrintWriter out = response.getWriter();
            out.println("System Error");
        }
    }
}
