package hibernate;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.List;


// CRUD операции
public class DAO {
    // до этого понадобится объект фабрики сеансов, есть два способа его создания
    // если мы работаем без аннотации:
    // ! процедура создания всех остальных объектов одинакова для обоих вариантов !
    SessionFactory factory_old = new Configuration().configure().buildSessionFactory();

    // с аннотацией:
//    SessionFactory factory = new AnnotationConfiguration().configure().addAnnotatedClass(FlightAnother.class).buildSessionFactory();

    // TODO: добавление объектов рейса Flight в БД - метод сохранения в объекте сеанса выполняет задачу вставки объекта
    // сохраняет объект в БД
    // далее выполняется транзакция в try-catch, чтобы в случае проблемы удалось выполнить откат
    // в противоположном случае - транзакция будет зафиксирована в таблице
    public void addFlight(Flight flight) {
        Session session = factory_old.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(flight);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) {
                tx.rollback();
            }
            he.printStackTrace();
        }
        session.close();
    }

    // TODO: операция обновления - обновляем уже существующие данные в таблице
    // сначала извлекаем объект Flight с заданным id, а затем обновляем номер рейса методом-сеттером
    // далее вызываем update-метод, чтобы обновить существующую сущность
    // ! если хочется вывести объекты, извлеченные из БД, на консоль, добавьте метод toString в класс POJO, иначе выведется хэш-код !
    public void updateFlightNumber(int id, String flightNumber) {
        Session session = factory_old.openSession();
        Transaction tx = null;
        try {
            Flight flight = session.get(Flight.class, id);
            flight.setFlightNumber(flightNumber);
            session.update(flight);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) {
                tx.rollback();
            }
            he.printStackTrace();
        }
        session.close();
    }

    // TODO: операция удаления - в БД есть только один объект с id = 1, попытаемся его удалить
    // После выполнения метода deleteFlight таблица становится пустой.
    // сначала извлекли объект по его id и передали его методу удаления.
    // Если все пойдет хорошо, транзакция окажется зафиксирована, в противном случае выполнится откат.
    public void deleteFlight(int id) {
        Session session = factory_old.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Flight flight = session.get(Flight.class, id);
            session.delete(flight);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) {
                tx.rollback();
            }
            he.printStackTrace();
        }
        session.close();
    }

    // TODO: Хотим ли мы обновить объект в БД или удалить его, нам понадобится значение его первичного ключа.
    //  Однако у нас не всегда есть возможность его получить. Кроме того, для этого необходимо выполнять сложные операции с данными.
    //  Цели можно достичь с помощью HQL, аналогичного SQL, но он удаляет шаблонный код.
    //  Это означает, что теперь не нужно использовать операторы SELECT с запросами.
    public void findByFlightNumber(String flightNumber) {
        Session session = factory_old.openSession();
        String hql = "from Flight where flightNumber=\'" + flightNumber + "\'";
        Query query = session.createQuery(hql);
        List<?> list = query.getResultList();
        session.close();
        System.out.println(list);
    }



    public static void main(String[] args) {
        // 1
        Flight flight = new Flight("A02987", "Delhi", "Mumbai", "16-06-2023", 7500);
        DAO daoAdd = new DAO();
        daoAdd.addFlight(flight);

        // 2
        DAO daoUpdate = new DAO();
        daoUpdate.updateFlightNumber(1, "B00012");

        // 3
        DAO daoDelete = new DAO();
        daoDelete.deleteFlight(1);

        // 4
        DAO daoFind = new DAO();
        daoFind.findByFlightNumber("AA0912");
    }


}