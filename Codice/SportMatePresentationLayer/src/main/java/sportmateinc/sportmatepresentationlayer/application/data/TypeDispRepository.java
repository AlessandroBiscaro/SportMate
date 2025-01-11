package sportmateinc.sportmatepresentationlayer.application.data;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TypeDispRepository extends JpaRepository<TypeDisp, Long>, JpaSpecificationExecutor<TypeDisp> {

}
