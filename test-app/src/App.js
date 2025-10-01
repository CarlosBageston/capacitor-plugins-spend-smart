import React, { useState } from 'react';
import './App.css';
import { NavigationBar } from 'capacitor-plugins-spend-smart';

function App() {
  const [colorIndex, setColorIndex] = useState(0);

  // Lista de cores e se os botões devem ser claros
  const colors = [
    { color: '#FF0000', lightButtons: true },   // vermelho, botões escuros
    { color: '#00FF00', lightButtons: false },  // verde, botões claros
    { color: '#0000FF', lightButtons: true },   // azul, botões escuros
    { color: '#FFFF00', lightButtons: false }   // amarelo, botões claros
  ];

  const changeNavBar = async () => {
    const nextIndex = (colorIndex + 1) % colors.length;
    const { color, lightButtons } = colors[nextIndex];

    try {
      await NavigationBar.setColor({ color, lightButtons });
      setColorIndex(nextIndex);
    } catch (err) {
      console.error('Erro ao mudar NavigationBar:', err);
    }
  };

  return (
    <div className="App">
      <header className="App-header">
        <h1>Teste NavigationBar Plugin</h1>
        <button onClick={changeNavBar} style={{ padding: '10px 20px', fontSize: '16px' }}>
          Mudar cor da Navigation Bar
        </button>
      </header>
    </div>
  );
}

export default App;
