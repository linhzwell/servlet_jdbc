package jp.co.sss.sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.sss.sample.bean.Account;
import jp.co.sss.sample.util.DBManager;

public class AccountDao {
    /**
     * ユーザ情報全件を検索
     *
     * @return 検索結果(ユーザ情報)
     * @throws ClassNotFoundException
     *             ドライバクラスが存在しない場合に送出
     * @throws SQLException
     *             データベース処理に失敗した場合に送出
     */
    public static List<Account> selectAll() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // DBに接続
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

            return list;

        } finally {
            // ResultSetをクローズ
            DBManager.close(resultSet);

            // PreparedStatementをクローズ
            DBManager.close(preparedStatement);

            // DBとの接続を切断
            DBManager.close(connection);
        }
    }

    /**
     * ユーザ情報1件を登録
     *
     * @param account
     *            ユーザ情報
     * @throws ClassNotFoundException
     *             ドライバクラスが存在しない場合に送出
     * @throws SQLException
     *             データベース処理に失敗した場合に送出
     */
    public static void insert(Account account) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // DBに接続
            connection = DBManager.getConnection();

            // SQL文を準備
            String sql = "INSERT INTO account VALUES(?, ?, ?)";

            // ステートメントを作成
            preparedStatement = connection.prepareStatement(sql);

            // 入力値をバインド
            preparedStatement.setInt(1, account.getId());
            preparedStatement.setString(2, account.getName());
            preparedStatement.setInt(3, account.getMoney());

            // SQL文を実行
            preparedStatement.executeUpdate();

        } finally {
            // PreparedStatementをクローズ
            DBManager.close(preparedStatement);

            // DBとの接続を切断
            DBManager.close(connection);
        }
    }

    /**
     * ユーザ情報1件を更新
     *
     * @param account
     *            ユーザ情報
     * @throws ClassNotFoundException
     *             ドライバクラスが存在しない場合に送出
     * @throws SQLException
     *             データベース処理に失敗した場合に送出
     */
    public static void update(Account account) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // DBに接続
            connection = DBManager.getConnection();

            // SQL文を準備
            String sql = "UPDATE account SET name = ?, money = ? WHERE id = ?";

            // ステートメントを作成
            preparedStatement = connection.prepareStatement(sql);

            // 入力値をバインド
            preparedStatement.setInt(3, account.getId());
            preparedStatement.setString(1, account.getName());
            preparedStatement.setInt(2, account.getMoney());

            // SQL文を実行
            preparedStatement.executeUpdate();

        } finally {
            // PreparedStatementをクローズ
            DBManager.close(preparedStatement);

            // DBとの接続を切断
            DBManager.close(connection);
        }
    }

    /**
     * ユーザ情報1件を削除
     *
     * @param account
     *            ユーザ情報
     * @throws ClassNotFoundException
     *             ドライバクラスが存在しない場合に送出
     * @throws SQLException
     *             データベース処理に失敗した場合に送出
     */
    public static void delete(Account account) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // DBに接続
            connection = DBManager.getConnection();

            // SQL文を準備
            String sql = "DELETE FROM account WHERE id = ?";

            // ステートメントを作成
            preparedStatement = connection.prepareStatement(sql);

            // 入力値をバインド
            preparedStatement.setInt(1, account.getId());

            // SQL文を実行
            preparedStatement.executeUpdate();

        } finally {
            // PreparedStatementをクローズ
            DBManager.close(preparedStatement);

            // DBとの接続を切断
            DBManager.close(connection);
        }
    }
}
