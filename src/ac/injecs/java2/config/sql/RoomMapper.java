package ac.injecs.java2.config.sql;

import ac.injecs.java2.entity.Room;
import ac.injecs.java2.entity.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomMapper extends SQLMapper {
    @Override
    public void insert(PreparedStatement preparedStatement, Object object) {
        try {
            Room room = (Room) object;

            this.preparedStatement = preparedStatement;

            preparedStatement.setString(1, room.getRoomInfo());
            preparedStatement.setBoolean(2, room.getdoorOpen());
            preparedStatement.setBoolean(3, room.getroomUsing());
            preparedStatement.setBoolean(4, room.gethasProjector());
            preparedStatement.setInt(5, room.getroomPeople());

            int row = preparedStatement.executeUpdate();

            System.out.println("추가된 row : " + row);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Object select(PreparedStatement preparedStatement) {
        List<Room> rooms = new ArrayList<>();

        try {
            this.preparedStatement = preparedStatement;
            this.resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                rooms.add(
                        new Room.Builder()
                                .roomInfo(resultSet.getString("rinfo"))
                                .doorOpen(resultSet.getBoolean("doorOpen"))
                                .roomUsing(resultSet.getBoolean("isUsing"))
                                .hasProjector(resultSet.getBoolean("isProject"))
                                .roomPeople(resultSet.getInt("posiMen"))
                                .build()
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(rooms.size() == 1){
            return rooms.get(0);
        }
        return rooms;
    }

}
