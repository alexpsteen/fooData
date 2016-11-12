package com.example.alexsteen.foodata;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Alex Steen on 11/12/2016.
 */

public class ConnectionClass {
    String ip = "128.61.73.140";
    String class_ = "net.sourceforge.jtds.jdbc.Driver";
    String db = "Android";
    String un = "alex";
    String password = "1234";

    @SuppressLint("NewApi")
    public Connection connect() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connection = null;
        String connectionURL = null;

        try {
            Class.forName(class_);
            connectionURL = "jdbc:jtds:sqlserver://" + ip + ";" + "databaseName="
                    + db + ";user=" + un + ";password=" + password + ";";
            connection = DriverManager.getConnection(connectionURL);
        } catch (SQLException e) {
            Log.e("ERROR", e.getMessage());
        } catch (ClassNotFoundException e) {
            Log.e("ERROR", e.getMessage());
        } catch (Exception e) {
            Log.e("ERROR", e.getMessage());
        }

        return connection;
    }
}
