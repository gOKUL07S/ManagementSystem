package Project.ManagementSystem;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

public final class DatabaseManager {

	private static Configuration config = new Configuration().configure().addAnnotatedClass(Account.class);

	private static ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();

	private static SessionFactory sf = config.buildSessionFactory(reg);

	private static Session session = sf.openSession();

	private static Transaction tx;

	public boolean Save(Account account) {
		
		if ((Account) GetAccount(account.getAccno()) != null) 
		{
			try {
				tx = session.beginTransaction();
				session.merge(account);
				tx.commit();
				tx = null;
				return true;
			} catch (Exception e) {
				System.out.println(e);
				return false;
			}
		}
		else 
		{
			try {
				tx = session.beginTransaction();
				session.persist(account);
				tx.commit();
				tx = null;
				return true;
			} catch (Exception e) {
				System.out.println(e);
				return false;
			}
		}
	}

	public Object GetAccount(long accno) {
		return (Account) session.get(Account.class, accno);
	}
	
	public ArrayList<Account> FetchAllAccounts()
	{
		try {
			String hql = "FROM Account";  // Account is the entity class, not the database table name
			Query<Account> query = session.createQuery(hql, Account.class);
			List<Account> accounts = query.getResultList();
			return new ArrayList<Account>(accounts);
		} catch (Exception e) {
			System.out.println(e);
			return new ArrayList<Account>();
		}
		
	}

}
