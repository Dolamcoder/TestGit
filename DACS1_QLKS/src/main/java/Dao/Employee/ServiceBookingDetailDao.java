package Dao.Employee;

import Model.ServiceBookingDetail;
import Util.JDBC;

import java.sql.*;
import java.util.ArrayList;

public class ServiceBookingDetailDao implements DaoInterface<ServiceBookingDetail> {
    @Override
    public boolean insert(ServiceBookingDetail detail) {
        String sql = "INSERT INTO ServiceBookingDetail (ServiceBookingID, ServiceID) VALUES (?, ?)";
        try (Connection conn = JDBC.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, detail.getServiceBookingID());
            ps.setInt(2, detail.getServiceID());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(ServiceBookingDetail detail) {
        // Không cần thiết nếu bạn không muốn cho phép sửa
        return false;
    }

    @Override
    public boolean delete(String id) {
        // Xoá theo serviceBookingID
        String sql = "DELETE FROM ServiceBookingDetail WHERE ServiceBookingID = ?";
        try (Connection conn = JDBC.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public ArrayList<ServiceBookingDetail> selectAll() {
        ArrayList<ServiceBookingDetail> list = new ArrayList<>();
        String sql = "SELECT * FROM ServiceBookingDetail";
        try (Connection conn = JDBC.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                int stt = rs.getInt("stt");
                String bookingID = rs.getString("ServiceBookingID");
                int serviceID = rs.getInt("ServiceID");

                list.add(new ServiceBookingDetail(stt, bookingID, serviceID));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
