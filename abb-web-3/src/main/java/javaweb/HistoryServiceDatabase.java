package javaweb;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HistoryServiceDatabase implements History {
    private final Connection connection;

    public HistoryServiceDatabase(Connection connection) {
        this.connection = connection;
    }

    @SneakyThrows
    @Override
    public void save(String user, HistoryItem item) {
        PreparedStatement st = connection.prepareStatement("insert into history (u, x, y, z, t) values (?,?,?,?,?)");
        st.setString(1, user);
        st.setInt(2, item.x);
        st.setInt(3, item.y);
        st.setInt(4, item.z);
        st.setString(5, item.ldt.toString());
        st.execute();
    }

    @SneakyThrows
    @Override
    public List<HistoryItem> getAll(String user) {
        PreparedStatement st = connection.prepareStatement("select * from history where u=?");
        st.setString(1, user);
        ResultSet resultSet = st.executeQuery();
        ArrayList<HistoryItem> data = new ArrayList<>();
        while (resultSet.next()) {
            data.add(new HistoryItem(
                    resultSet.getInt("x"),
                    resultSet.getInt("y"),
                    resultSet.getInt("z"),
                    LocalDateTime.parse(resultSet.getString("t"))
            ));
        }
        return data;
    }

    @SneakyThrows
    @Override
    public void delete(String user) {
        PreparedStatement st = connection.prepareStatement("delete from history where u = ?");
        st.setString(1, user);
        st.execute();
    }
}
