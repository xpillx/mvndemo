package sql;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class AbstrDBManager {
	private ApplicationContext context = null;

	public ApplicationContext getContext() {
		return context;
	}

	public void setContext(ApplicationContext context) {
		this.context = context;
	}

	/**
	 * ‘ÿ»Îspring≈‰÷√Œƒº˛
	 */
	public void init(String path) {
		context = new ClassPathXmlApplicationContext("file:" + path
				+ "/mvndemo/conf/applicationContext-sql.xml");
		this._init();
	}

	public Object getBean(String name) {
		return context.getBean(name);
	}

	protected abstract void _init();
}
