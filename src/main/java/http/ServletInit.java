package http;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import base.Player;
import sql.DbManager;
import util.JsonUtil;
import log4.Log;
import log4.LogMvn;

public class ServletInit implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		String path = System.getProperty("wtp.deploy");
		Log.Init(path);
		DbManager.getInstance().init(path);
		LogMvn.infoTest1("服务器启动成功");
		LogMvn.infoTest2("服务器启动成功");
		LogMvn.infoTest3("服务器启动成功");

		// Player player = new Player(1, "gww", 22);
		LogMvn.infoTest3(JsonUtil.ObjectToJson(DbManager.getInstance()
				.getGameDAO().getPlayers()));
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		LogMvn.infoTest1("服务器关闭");
		LogMvn.infoTest2("服务器关闭");
		LogMvn.infoTest3("服务器关闭");
	}

}
