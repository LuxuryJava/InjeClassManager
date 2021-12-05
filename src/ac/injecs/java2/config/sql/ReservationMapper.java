package ac.injecs.java2.config.sql;
import ac.injecs.java2.entity.ResInfo;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationMapper extends SQLMapper {

    @Override
    public void update(PreparedStatement preparedStatement, Object object) {
        try {
            ResInfo resInfo = (ResInfo) object;

            this.preparedStatement = preparedStatement;

            preparedStatement.setBoolean(1, resInfo.getaccept());
            preparedStatement.setString(2, String.valueOf(resInfo.getuno()));
            preparedStatement.setString(3, resInfo.getrinfo());
            preparedStatement.setString(4, resInfo.getusetime());
            preparedStatement.setString(5, resInfo.getuseday());

            int result = preparedStatement.executeUpdate();
            System.out.println("resinfo update = " + result);
            JOptionPane.showMessageDialog(null,"예약 승인/거부가 완료되었습니다.");

        } catch (SQLException e) {
            JOptionPane .showMessageDialog(null,"예약 승인/거부 오류");
            System.out.println(e);
        }
    }

    @Override
    public void delete(PreparedStatement preparedStatement, Object object) {
        try {
            ResInfo resInfo = (ResInfo) object;

            this.preparedStatement = preparedStatement;

            preparedStatement.setString(1, String.valueOf(resInfo.getuno()));
            preparedStatement.setString(2, resInfo.getrinfo());
            preparedStatement.setString(3, resInfo.getusetime());
            preparedStatement.setString(4, resInfo.getuseday());

            int result = preparedStatement.executeUpdate();
            System.out.println("resinfo delete = " + result);
        } catch (SQLException e) {
            JOptionPane .showMessageDialog(null,"예약 삭제 오류.");
            System.out.println(e);
        }
    }

    @Override
    public void insert(PreparedStatement preparedStatement, Object object) {
        try {
            ResInfo res = (ResInfo) object;

            this.preparedStatement = preparedStatement;

            preparedStatement.setInt(1, res.getuno());
            preparedStatement.setString(2, res.getrinfo());
            preparedStatement.setString(3, res.getuseday());
            preparedStatement.setInt(4, res.getmemcnt());
            preparedStatement.setString(5, res.getusetime());
            preparedStatement.setString(6, res.getpurpose());
            preparedStatement.setBoolean(7, false);

            int result = preparedStatement.executeUpdate();
            if(result==1) {
                System.out.println("reservation데이터 삽입 성공!");
            }
            else {
                JOptionPane.showMessageDialog(null, ":최대인원초과",  "MESSAGE", JOptionPane.WARNING_MESSAGE);
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
