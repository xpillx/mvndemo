package sql.game;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import log4.LogMvn;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import sql.game.row.PlayerDataRowMapper;
import base.Player;

public class GameDao extends JdbcDaoSupport {
	// 操作数据
	private static final String SQL_ADDPLAYER = "INSERT INTO playerdata (id,name ,age)"
			+ "values(?,?,?)";

	private static final String SQL_UPDATEPLAYER = "update playerdata set name=?,age=? where id=?";

	private static final String SQL_DELETEPLAYER = "delete from playerdata where id=?";

	private static final String SQL_ALL_PLAYERDATA = "select * from playerdata";

	// 查询数据
	PlayerDataRowMapper playerDataRowMapper = new PlayerDataRowMapper();

	// 添加数据
	public boolean addPlayer(final Player player) {
		try {
			getJdbcTemplate().update(new PreparedStatementCreator() {
				public PreparedStatement createPreparedStatement(Connection conn)
						throws SQLException {
					PreparedStatement ps = conn.prepareStatement(SQL_ADDPLAYER,
							Statement.RETURN_GENERATED_KEYS);
					int cursor = 1;
					ps.setInt(cursor++, player.getId());
					ps.setString(cursor++, player.getName());
					ps.setInt(cursor++, player.getAge());
					return ps;
				};
			});
		} catch (Exception e) {
			LogMvn.infoTest3("GameDao addPlayer e:" + e.getMessage());
			return false;
		}
		return true;
	}

	// 更新数据
	public boolean updatePlayer(Player player) {
		try {
			getJdbcTemplate().update(SQL_UPDATEPLAYER, player.getName(),
					player.getAge(), player.getId());
			return true;
		} catch (Exception e) {
			LogMvn.infoTest3("GameDao updatePlayer e:" + e.getMessage());
			return false;
		}
	}

	// 删除数据
	public boolean deletePlayer(Player player) {
		try {
			getJdbcTemplate().update(SQL_DELETEPLAYER, player.getId());
			return true;
		} catch (Exception e) {
			LogMvn.infoTest3("GameDao updatePlayer e:" + e.getMessage());
			return false;
		}
	}

	public List<Player> getPlayers() {
		try {
			List<Player> roleDatas = getJdbcTemplate().query(
					SQL_ALL_PLAYERDATA, playerDataRowMapper);
			return roleDatas;
		} catch (Exception e) {
			LogMvn.infoTest3("GameDao getPlayers e:" + e.getMessage());
			return null;
		}
	}
}
