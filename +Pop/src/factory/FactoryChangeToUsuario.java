package factory;

import java.io.Serializable;

import usuario.CelebridadePOP;
import usuario.IconePOP;
import usuario.Normal;
import usuario.TipoUsuario;

public class FactoryChangeToUsuario implements Serializable {

	private static final long serialVersionUID = 1L;

	public TipoUsuario changeToUsuarioNormal() {

		return new Normal();

	}

	public TipoUsuario changeToUsuarioCelebridadePOP() {

		return new CelebridadePOP();

	}

	public TipoUsuario changeToUsuarioIconePOP() {

		return new IconePOP();

	}
}