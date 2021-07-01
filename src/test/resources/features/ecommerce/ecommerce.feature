@Comprando
Feature: ComprandoNoEcommerce
  Fluxo de compras no e-commerce

  @CompraSimples
  Scenario Outline: Realizar uma compra simples
    Given que acesso ao Swaglabs
    And utilizo o <username> para logar
    And compro uma mochila
    Then finalizo a compra

    Examples:
      | username       |
      | "standard_user"|
