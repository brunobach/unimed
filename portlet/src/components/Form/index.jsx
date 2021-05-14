import { useState, useEffect } from "react";
import axios from "axios";

import "./styles.css";

function Form() {
  const [nome, setNome] = useState("");
  const [email, setEmail] = useState("");
  const [telefone, setTelefone] = useState("");
  const [mensagem, setMensagem] = useState("");

  const [uf, setUf] = useState("");
  const [listUf, setListUf] = useState([]);
  const [ufForm, setUfForm] = useState([]);
  const [city, setCity] = useState("");
  const [listCity, setListCity] = useState([]);
  const [protocolo, setProtocolo] = useState("");
  const [isAlert, setIsAlert] = useState(false);

  function loadUf() {
    const url = "http://localhost:8089/api/estados";
    axios.get(url).then((res) => {
      setUfForm([...res.data]);
      res.data.sort((a, b) => a.nome.localeCompare(b.nome));
      setListUf([...res.data]);
    });
  }
  function loadCity(id) {
    const url = `http://localhost:8089/api/cidades/${id}`;
    axios
      .get(url)

      .then((res) => {
        res.data.sort((a, b) => a.nome.localeCompare(b.nome));
        setListCity([...res.data]);
      });
  }
  useEffect(() => {
    loadUf();
  }, []);

  useEffect(() => {
    if (uf) {
      loadCity(uf);
    }
  }, [uf]);

  function handleInputRegister(e) {
    e.preventDefault();
    const estadoStr = ufForm.filter((_uf) => _uf.id === Number(uf));

    const url = "http://localhost:8089/api/formulario";

    axios
      .post(url, {
        nome,
        email,
        estado: estadoStr[0].nome,
        cidade: city,
        telefone,
        mensagem,
      })
      .then((res) => {
        setNome("");
        setEmail("");
        setUf("");
        setCity("");
        setTelefone("");
        setMensagem("");

        setProtocolo(res.data);
        setIsAlert(true);
      });
  }

  function handleRemoveBlur() {
    if (isAlert) {
      setIsAlert(false);
    }
  }
  return (
    <div className="container" onClick={handleRemoveBlur}>
      <div className={isAlert ? "protocolo-wrapper" : "invisible"}>
        <div className="protocolo">
          <div className="circle">
            <svg
              stroke="currentColor"
              fill="currentColor"
              stroke-width="0"
              version="1"
              viewBox="0 0 48 48"
              enable-background="new 0 0 48 48"
              height="4em"
              width="4em"
              xmlns="http://www.w3.org/2000/svg"
            >
              <polygon
                fill="#43A047"
                points="40.6,12.1 17,35.7 7.4,26.1 4.6,29 17,41.3 43.4,14.9"
              ></polygon>
            </svg>
          </div>
          <h2>Protocolo Gerado</h2>
          <h3>{protocolo}</h3>
        </div>
      </div>
      <form
        className={isAlert ? "form-blur" : ""}
        onSubmit={(event) => handleInputRegister(event)}
      >
        <label htmlFor="nome">Nome</label>
        <input
          required
          id="nome"
          value={nome}
          type="text"
          onChange={(e) => setNome(e.target.value)}
        />

        <label htmlFor="email">E-mail</label>
        <input
          required
          id="email"
          value={email}
          type="email"
          onChange={(e) => setEmail(e.target.value)}
        />

        <label htmlFor="states">Estado</label>
        <select
          value={uf}
          onChange={(e) => {
            setUf(e.target.value);
          }}
        >
          <option value="">Selecione um estado</option>
          {listUf.map((a, b) => (
            <option value={a.id}>{a.nome}</option>
          ))}
        </select>
        <label htmlFor="states">Cidades</label>
        <select value={city} onChange={(e) => setCity(e.target.value)}>
          <option value="">Selecione uma cidade</option>
          {listCity.map((a, b) => (
            <option value={a.sigla}>{a.nome}</option>
          ))}
        </select>

        <label htmlFor="telefone">Telefone</label>
        <input
          required
          type="number"
          value={telefone}
          onChange={(e) => setTelefone(e.target.value)}
        />

        <label htmlFor="mensagem">Mensagem</label>
        <textarea
          required
          value={mensagem}
          onChange={(e) => setMensagem(e.target.value)}
        />
        <button>Enviar</button>
      </form>
    </div>
  );
}

export default Form;
