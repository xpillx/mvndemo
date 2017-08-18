package sql.game.row;

import java.sql.ResultSet;
import java.sql.SQLException;

import log4.LogMvn;

import org.springframework.jdbc.core.RowMapper;

import base.Player;

//查询模版(将数据转化为需要对象)
public class PlayerDataRowMapper implements RowMapper<Player> {

	@Override
	public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
		Player player = new Player();
		try {
			/*
			 * player.setId(rs.getInt("ID"));
			 * player.setName(rs.getString("NAME"));
			 * player.setAge(rs.getInt("AGE"));
			 */
			player.setId(rs.getInt(1));
			player.setName(rs.getString(2));
			player.setAge(rs.getInt(3));
		} catch (Exception e) {
			LogMvn.infoTest3("PlayerDataRowMapper mapRow e:" + e.getMessage());
		}
		return player;
	}

}
