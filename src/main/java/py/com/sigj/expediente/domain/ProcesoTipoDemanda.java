package py.com.sigj.expediente.domain;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import py.com.sigj.main.GenericEntity;

/**
 * Clase intermedia que relaciona los tipos de demandas de acuerdo a los
 * procesos registrados.
 * 
 * @author Luis A. Méndez R.
 *
 */
@Entity
@Table(name = "proceso_tipo_demanda", uniqueConstraints = {
		@UniqueConstraint(name = "proceso_tipoDemanda_uk", columnNames = { "proceso_id", "tipodemanda_id" }) })
public class ProcesoTipoDemanda extends GenericEntity {
	private static final String SECUENCIA = "procesoTipoDemanda_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	@ManyToOne
	@NotNull(message = "proceso.tipoDemanda.notNull")
	@JoinColumn(foreignKey = @ForeignKey(name = "procesoTipoDemanda_proceso_fk"))
	private Proceso proceso;

	@ManyToOne
	@NotNull(message = "procesoTipoDemanda.tipoDemanda.notNull")
	@JoinColumn(foreignKey = @ForeignKey(name = "procesoTipoDemanda_tipoDemanda_fk"))
	private TipoDemanda tipoDemanda;

	public ProcesoTipoDemanda() {

	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public Proceso getProceso() {
		return proceso;
	}

	public void setProceso(Proceso proceso) {
		this.proceso = proceso;
	}

	public TipoDemanda getTipoDemanda() {
		return tipoDemanda;
	}

	public void setTipoDemanda(TipoDemanda tipoDemanda) {
		this.tipoDemanda = tipoDemanda;
	}

	@Override
	public String toString() {
		return "ProcesoTipoDemanda [id=" + id + ", proceso=" + proceso + ", tipoDemanda=" + tipoDemanda + "]";
	}

}
