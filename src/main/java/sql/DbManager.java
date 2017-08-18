package sql;

import sql.game.GameDao;

public class DbManager extends AbstrDBManager {
	private static DbManager instance = null;

	public static DbManager getInstance() {
		if (instance == null) {
			instance = new DbManager();
		}
		return instance;
	}

	private GameDao gameDAO;

	@Override
	protected void _init() {
		gameDAO = (GameDao) getBean("gameDAO");
	}

	public GameDao getGameDAO() {
		return gameDAO;
	}

	public void setGameDAO(GameDao gameDao) {
		this.gameDAO = gameDao;
	}
}
