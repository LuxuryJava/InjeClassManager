package ac.injecs.java2.config.sql;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;

import ac.injecs.java2.entity.Door;
import ac.injecs.java2.entity.Room;

public class DoorMapper extends SQLMapper {

	@Override
	public void insert(PreparedStatement preparedStatement, Object object) {
		try {
            Door door = (Door) object;

            this.preparedStatement = preparedStatement;

			preparedStatement.setString(1, door.getuno());
			preparedStatement.setString(2, door.getrinfo());
			preparedStatement.setBoolean(3, door.getdoorOpen());

            int row = preparedStatement.executeUpdate();

            System.out.println("추가된 row : " + row);
            JOptionPane.showMessageDialog(null,"개방/잠금 요청 되었습니다.");

        } catch (SQLException e) {
            //e.printStackTrace();
            JOptionPane.showMessageDialog(null,"이미 요청되었습니다.");
        }

	}

//	@Override
//	public Object select(PreparedStatement preparedStatement) {
//		Vector<Object> doors = new Vector<Object>();
//		
//        try {
//            this.preparedStatement = preparedStatement;
//            this.resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//            	doors.add(
//                        (Object)new Door.Builder()
//                                .setuno(resultSet.getString("uno"))
//                                .setrinfo(resultSet.getString("rinfo"))
//                                .setdoorOpen(resultSet.getBoolean("doorOpen"))
//                                .build()
//                );
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        if(doors.size() == 1){
//            return doors.get(0);
//        }
//        return doors;
//	}

	@Override
	public void update(PreparedStatement preparedStatement, Object object) {
		try {
            Door door = (Door) object;

            this.preparedStatement = preparedStatement;

			preparedStatement.setString(2, door.getuno());
			preparedStatement.setString(3, door.getrinfo());
			preparedStatement.setBoolean(1, door.getdoorOpen());

            int row = preparedStatement.executeUpdate();

            System.out.println("추가된 row : " + row);
            JOptionPane .showMessageDialog(null,"개방/잠금 요청 되었습니다.");

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"이미 요청되었습니다.");
        }
	}
	
	@Override
	public void delete(PreparedStatement preparedStatement, Object object) {
		try {
			Door door = (Door) object;
			
			this.preparedStatement = preparedStatement;
			
			preparedStatement.setString(1, door.getrinfo());
			
			int row = preparedStatement.executeUpdate();
			JOptionPane.showMessageDialog(null,"개방/잠금 완료");
			
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "개방/잠금 오류");
		}
	}

	@Override
	public Object select(PreparedStatement preparedStatement) {
		// TODO Auto-generated method stub
		return null;
	}
}
