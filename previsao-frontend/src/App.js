import React, { useState } from "react";
import axios from "axios";
import styled from "styled-components";

const API_URL = "http://localhost:8080/previsao";

// 🎨 Estilos para o tema escuro
const Container = styled.div`
  max-width: 800px; /* 🔼 Aumentei a largura */
  margin: 40px auto;
  padding: 20px;
  border-radius: 10px;
  background: #1e1e1e;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
  font-family: Arial, sans-serif;
  color: #fff;
`;

const Title = styled.h2`
  text-align: center;
  color: #00d9ff;
`;

const Input = styled.input`
  width: calc(100% - 20px);
  padding: 10px;
  margin: 5px 0;
  border: 1px solid #555;
  border-radius: 5px;
  background: #2e2e2e;
  color: white;

  &:focus {
    border-color: #00d9ff;
    outline: none;
  }
`;

const Button = styled.button`
  width: 100%;
  padding: 10px;
  margin-top: 10px;
  background: #00d9ff;
  color: black;
  font-weight: bold;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  transition: 0.3s;

  &:hover {
    background: #008bb5;
  }
`;

const ListItem = styled.li`
  list-style: none;
  padding: 8px 12px; /* 🔽 Reduzi o padding */
  background: #2e2e2e;
  margin: 5px 0;
  display: flex;
  justify-content: space-between;
  align-items: center;
  border-radius: 5px;
  font-size: 14px; /* 🔽 Reduzi um pouco a fonte */
  white-space: nowrap; /* ⏩ Mantém tudo em uma linha */
  overflow: hidden;
  text-overflow: ellipsis;
`;

const DeleteButton = styled.button`
  background: red;
  color: white;
  border: none;
  padding: 5px 10px;
  border-radius: 5px;
  cursor: pointer;
  transition: 0.3s;

  &:hover {
    background: darkred;
  }
`;

function App() {
  const [previsoes, setPrevisoes] = useState([]);
  const [pedido, setPedido] = useState("");
  const [fornecedor, setFornecedor] = useState("");
  const [cotacao, setCotacao] = useState("");
  const [dataPrevisao, setDataPrevisao] = useState("");
  const [cotacaoBusca, setCotacaoBusca] = useState("");

  // 🔍 Buscar previsões por cotação
  const buscarPrevisoes = () => {
    if (!cotacaoBusca) {
      alert("Digite um número de cotação para buscar.");
      return;
    }

    axios
      .get(`${API_URL}/cotacao?cotacao=${cotacaoBusca}`)
      .then((response) => setPrevisoes(response.data))
      .catch((error) => console.error("Erro ao buscar previsões", error));
  };

  // ➕ Adicionar nova previsão
  const adicionarPrevisao = () => {
    axios
      .post(API_URL, {
        pedido: parseInt(pedido),
        fornecedor,
        cotacao: parseFloat(cotacao),
        previsao: dataPrevisao,
      })
      .then(() => {
        setPedido("");
        setFornecedor("");
        setCotacao("");
        setDataPrevisao("");
        buscarPrevisoes();
      })
      .catch((error) => console.error("Erro ao adicionar previsão", error));
  };

  // ❌ Excluir previsão
  const excluirPrevisao = (id) => {
    axios
      .delete(`${API_URL}?id=${id}`)
      .then(() => buscarPrevisoes())
      .catch((error) => console.error("Erro ao excluir previsão", error));
  };

  return (
    <Container>
      <Title>📅 Gerenciamento de Previsões</Title>

      {/* 🔍 Buscar por Cotação */}
      <div>
        <Input
          type="number"
          placeholder="💰 Buscar por Cotação"
          value={cotacaoBusca}
          onChange={(e) => setCotacaoBusca(e.target.value)}
        />
        <Button onClick={buscarPrevisoes}>Buscar</Button>
      </div>

      {/* ➕ Adicionar nova previsão */}
      <div>
        <h3>➕ Adicionar Previsão</h3>
        <Input
          type="number"
          placeholder="📦 Pedido"
          value={pedido}
          onChange={(e) => setPedido(e.target.value)}
        />
        <Input
          type="text"
          placeholder="🏭 Fornecedor"
          value={fornecedor}
          onChange={(e) => setFornecedor(e.target.value)}
        />
        <Input
          type="number"
          step="0.01"
          placeholder="💰 Cotação"
          value={cotacao}
          onChange={(e) => setCotacao(e.target.value)}
        />
        <Input
          type="date"
          value={dataPrevisao}
          onChange={(e) => setDataPrevisao(e.target.value)}
        />
        <Button onClick={adicionarPrevisao}>Adicionar</Button>
      </div>

      {/* 📋 Lista de Previsões */}
      <h3>📋 Lista de Previsões</h3>
      <ul>
        {previsoes.map((prev) => (
          <ListItem key={prev.id}>
            <span>
              <strong>Pedido:</strong> {prev.pedido} | <strong>Fornecedor:</strong> {prev.fornecedor} | <strong>Cotação:</strong> {prev.cotacao} | <strong>Data:</strong> {prev.previsao}
            </span>
            <DeleteButton onClick={() => excluirPrevisao(prev.id)}>X</DeleteButton>
          </ListItem>
        ))}
      </ul>
    </Container>
  );
}

export default App;
