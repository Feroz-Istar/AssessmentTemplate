package dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.Assessment;

/**
 * A data access object (DAO) providing persistence and search support for
 * Assessment entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.Assessment
 * @author MyEclipse Persistence Tools
 */
public class AssessmentDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(AssessmentDAO.class);
	// property constants
	public static final String IMAGE_URL = "imageUrl";
	public static final String TYPE = "type";

	public void save(Assessment transientInstance) {
		log.debug("saving Assessment instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Assessment persistentInstance) {
		log.debug("deleting Assessment instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Assessment findById(java.lang.Integer id) {
		log.debug("getting Assessment instance with id: " + id);
		try {
			Assessment instance = (Assessment) getSession().get("com.Assessment", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Assessment> findByExample(Assessment instance) {
		log.debug("finding Assessment instance by example");
		try {
			List<Assessment> results = (List<Assessment>) getSession().createCriteria("com.Assessment")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Assessment instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Assessment as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Assessment> findByImageUrl(Object imageUrl) {
		return findByProperty(IMAGE_URL, imageUrl);
	}

	public List<Assessment> findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List findAll() {
		log.debug("finding all Assessment instances");
		try {
			String queryString = "from Assessment";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Assessment merge(Assessment detachedInstance) {
		log.debug("merging Assessment instance");
		try {
			Assessment result = (Assessment) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Assessment instance) {
		log.debug("attaching dirty Assessment instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Assessment instance) {
		log.debug("attaching clean Assessment instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}