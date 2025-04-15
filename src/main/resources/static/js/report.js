fetch("http://localhost:8080/payments")
  .then(response => response.json())
  .then(data => {
    const tbody = document.querySelector("#tabela-relatorio tbody");

    data.forEach(item => {
      const row = document.createElement("tr");

      row.innerHTML = `
        <td>${item.id}</td>
        <td>${item.cliente}</td>
        <td>${item.produto}</td>
        <td>${item.quantidade}</td>
        <td>R$ ${item.valorTotal.toFixed(2)}</td>
      `;

      tbody.appendChild(row);
    });
  })
  .catch(err => console.error("Erro ao buscar os dados:", err));
