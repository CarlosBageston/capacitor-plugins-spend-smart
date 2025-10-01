export interface NavigationBarPlugin {
  /**
   * Altera a cor da navigation bar e a cor dos botões
   * @param color - string HEX, ex: "#FF0000"
   * @param lightButtons - se true, deixa os botões escuros (para fundo claro)
   */
  setColor(options: { color: string; lightButtons?: boolean }): Promise<void>;
}
