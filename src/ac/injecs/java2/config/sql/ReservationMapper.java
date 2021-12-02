package ac.injecs.java2.config.sql;

import ac.injecs.java2.entity.Notice;
import ac.injecs.java2.entity.ResInfo;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationMapper extends SQLMapper {

    @Override
    public void insert(PreparedStatement preparedStatement, Object object) {
        String sql="insert into reservation values(?,?,?,?,?,?,?)";
        try {
            ResInfo res = (ResInfo) object;

            this.preparedStatement = preparedStatement;

            preparedStatement.setInt(1, res.getuno());
            preparedStatement.setString(2, res.getrinfo());
            preparedStatement.setInt(3, res.getmemcnt());
            preparedStatement.setString(4, res.getuseday());
            preparedStatement.setString(5, res.getusetime());
            preparedStatement.setString(6, res.getpurpose());
            preparedStatement.setBoolean(7, false);

            int result = preparedStatement.executeUpdate();
            if(result==1) {
                System.out.println("reservation데이터 삽입 성공!");

            }

        } catch (Exception e) {
            System.out.println(e);
        }    finally {
            try {
                if(preparedStatement!=null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (Exception e2) {}
        }
    }

    @Override
    public Object select(PreparedStatement preparedStatement) {
        List<ResInfo> resInfos = new ArrayList<>();
        try {
            this.preparedStatement = preparedStatement;
            this.resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                ResInfo ri=new ResInfo(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4),
                        resultSet.getString(5),resultSet.getString(6), resultSet.getBoolean(7));
                resInfos.add(ri);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(resInfos.size() == 0){
            return null;
        }
        return resInfos;
    }
}
