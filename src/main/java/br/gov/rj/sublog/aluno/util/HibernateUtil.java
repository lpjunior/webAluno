package br.gov.rj.sublog.aluno.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import jdk.internal.org.jline.utils.Log;

public class HibernateUtil {
	private static final Logger logger = LogManager.getLogger(HibernateUtil.class);
	private static final EntityManager entityManager = buildEntityManagerFactory();

	private static EntityManager buildEntityManagerFactory() {

		try {
			System.out.println("===================================> PASSOU AQUI 1 <===================================");
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("sublog-pu");
			System.out.println("===================================> PASSOU AQUI 2 <===================================");
			EntityManager em = emf.createEntityManager();
			System.out.println("===================================> PASSOU AQUI 3 <===================================");
			return em;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error ao gerar o em: " + e.getMessage());
		}
		return null;
	}

	public static EntityManager getEntitymanager() {
		return entityManager;
	}
}
