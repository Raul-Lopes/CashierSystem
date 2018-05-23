-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: May 23, 2018 at 01:29 PM
-- Server version: 5.7.19
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbcomum`
--

-- --------------------------------------------------------

--
-- Table structure for table `clienpdv`
--

DROP TABLE IF EXISTS `clienpdv`;
CREATE TABLE IF NOT EXISTS `clienpdv` (
  `CLCODIGO` int(11) DEFAULT NULL,
  `TIPO` varchar(1) DEFAULT NULL,
  `NOME` varchar(42) DEFAULT NULL,
  `FANTASIA` varchar(6) DEFAULT NULL,
  `SITUACAO` varchar(1) DEFAULT NULL,
  `VIP` varchar(1) DEFAULT NULL,
  `ENDERECO` varchar(34) DEFAULT NULL,
  `BAIRRO` varchar(15) DEFAULT NULL,
  `CICODIGO` int(11) DEFAULT NULL,
  `UF` varchar(2) DEFAULT NULL,
  `CEP` varchar(8) DEFAULT NULL,
  `COENDERE` varchar(0) DEFAULT NULL,
  `COBAIRRO` varchar(0) DEFAULT NULL,
  `COCICODIGO` varchar(0) DEFAULT NULL,
  `COUF` varchar(0) DEFAULT NULL,
  `COCEP` varchar(0) DEFAULT NULL,
  `TELEFONE` varchar(10) DEFAULT NULL,
  `CONTATO` varchar(0) DEFAULT NULL,
  `FAX` varchar(10) DEFAULT NULL,
  `CAIXAPOS` varchar(0) DEFAULT NULL,
  `WEB` varchar(0) DEFAULT NULL,
  `EMAIL` varchar(0) DEFAULT NULL,
  `EMAILPEDIDO` varchar(0) DEFAULT NULL,
  `CGC` int(11) DEFAULT NULL,
  `CPF` varchar(11) DEFAULT NULL,
  `INSCRICA` varchar(13) DEFAULT NULL,
  `IDENTIDA` varchar(0) DEFAULT NULL,
  `RACODIGO` varchar(0) DEFAULT NULL,
  `OBS` varchar(0) DEFAULT NULL,
  `FUCODIGO` varchar(0) DEFAULT NULL,
  `EMCODIGO` varchar(0) DEFAULT NULL,
  `DATANASC` varchar(0) DEFAULT NULL,
  `FICODIGO` varchar(0) DEFAULT NULL,
  `MKCODIGO` varchar(0) DEFAULT NULL,
  `ENDENVREC` varchar(0) DEFAULT NULL,
  `BAIENVREC` varchar(0) DEFAULT NULL,
  `CIENVREC` varchar(0) DEFAULT NULL,
  `UFENVREC` varchar(0) DEFAULT NULL,
  `CEPENVREC` varchar(0) DEFAULT NULL,
  `EMPRESA` varchar(0) DEFAULT NULL,
  `BANCO` varchar(0) DEFAULT NULL,
  `COMENTARIOV` varchar(0) DEFAULT NULL,
  `VALOR_MAXV` varchar(0) DEFAULT NULL,
  `VALOR_MINV` varchar(0) DEFAULT NULL,
  `ANOV` varchar(0) DEFAULT NULL,
  `ANO` varchar(0) DEFAULT NULL,
  `MVCODIGOV` varchar(0) DEFAULT NULL,
  `MRCODIGOV` varchar(0) DEFAULT NULL,
  `FONE_COM` varchar(0) DEFAULT NULL,
  `FONE_CEL` varchar(0) DEFAULT NULL,
  `SEXO` varchar(1) DEFAULT NULL,
  `CARGO` varchar(0) DEFAULT NULL,
  `PROFISSAO` varchar(0) DEFAULT NULL,
  `LIMITECRE` int(11) DEFAULT NULL,
  `LIMITESEC` int(11) DEFAULT NULL,
  `VLRDEBITO` varchar(0) DEFAULT NULL,
  `CADLOCAL` varchar(1) DEFAULT NULL,
  `CODINTERN` varchar(0) DEFAULT NULL,
  `DESFOLHA` varchar(0) DEFAULT NULL,
  `CLCODPAI` varchar(0) DEFAULT NULL,
  `DATAALTE` varchar(19) DEFAULT NULL,
  `DATACADA` varchar(0) DEFAULT NULL,
  `REFERENCIA` varchar(0) DEFAULT NULL,
  `SENHA` varchar(0) DEFAULT NULL,
  `PATHFOTO` varchar(0) DEFAULT NULL,
  `APCICMS` varchar(0) DEFAULT NULL,
  `COMPRAATACADO` varchar(0) DEFAULT NULL,
  `ORGEXPIDEN` varchar(0) DEFAULT NULL,
  `UFEMIIDEN` varchar(0) DEFAULT NULL,
  `PRODCODIGO` varchar(0) DEFAULT NULL,
  `NOMEPAI` varchar(0) DEFAULT NULL,
  `NOMEMAE` varchar(0) DEFAULT NULL,
  `DIAFIXPAGAMENTO` varchar(0) DEFAULT NULL,
  `ADIANTAMENTO` varchar(0) DEFAULT NULL,
  `FLAGTRANS` varchar(0) DEFAULT NULL,
  `OBSEXIB` varchar(0) DEFAULT NULL,
  `CODIBGE` varchar(0) DEFAULT NULL,
  `CODCONTAB` varchar(0) DEFAULT NULL,
  `TPENDERECOCOM` int(11) DEFAULT NULL,
  `TPENDERECOCOBR` varchar(0) DEFAULT NULL,
  `TPENDERECOREC` varchar(0) DEFAULT NULL,
  `COMPLEMENTOCOM` varchar(10) DEFAULT NULL,
  `COMPLEMENTOCOBR` varchar(0) DEFAULT NULL,
  `COMPLEMENTOREC` varchar(0) DEFAULT NULL,
  `NUMEROCOM` varchar(4) DEFAULT NULL,
  `NUMEROCOBR` varchar(0) DEFAULT NULL,
  `NUMEROREC` varchar(0) DEFAULT NULL,
  `INSCMUN` varchar(0) DEFAULT NULL,
  `DEDUPIS` varchar(0) DEFAULT NULL,
  `DEDUCOFINS` varchar(0) DEFAULT NULL,
  `DEDUCSLL` varchar(0) DEFAULT NULL,
  `DEDUINSS` varchar(0) DEFAULT NULL,
  `DEDUISSQN` varchar(0) DEFAULT NULL,
  `HIST_CLI` varchar(0) DEFAULT NULL,
  `SUFRAMA` varchar(0) DEFAULT NULL,
  `NOMEDEP` varchar(0) DEFAULT NULL,
  `CPFDEPEN` varchar(0) DEFAULT NULL,
  `DOCDEPEN` varchar(0) DEFAULT NULL,
  `NOMEDEP2` varchar(0) DEFAULT NULL,
  `CPFDEPEN2` varchar(0) DEFAULT NULL,
  `DOCDEPEN2` varchar(0) DEFAULT NULL,
  `NOMEDEP3` varchar(0) DEFAULT NULL,
  `CPFDEPEN3` varchar(0) DEFAULT NULL,
  `DOCDEPEN3` varchar(0) DEFAULT NULL,
  `ALIQCSLL` varchar(0) DEFAULT NULL,
  `ALIQINSS` varchar(0) DEFAULT NULL,
  `ALIQIRRF` varchar(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `clienpdv`
--

INSERT INTO `clienpdv` (`CLCODIGO`, `TIPO`, `NOME`, `FANTASIA`, `SITUACAO`, `VIP`, `ENDERECO`, `BAIRRO`, `CICODIGO`, `UF`, `CEP`, `COENDERE`, `COBAIRRO`, `COCICODIGO`, `COUF`, `COCEP`, `TELEFONE`, `CONTATO`, `FAX`, `CAIXAPOS`, `WEB`, `EMAIL`, `EMAILPEDIDO`, `CGC`, `CPF`, `INSCRICA`, `IDENTIDA`, `RACODIGO`, `OBS`, `FUCODIGO`, `EMCODIGO`, `DATANASC`, `FICODIGO`, `MKCODIGO`, `ENDENVREC`, `BAIENVREC`, `CIENVREC`, `UFENVREC`, `CEPENVREC`, `EMPRESA`, `BANCO`, `COMENTARIOV`, `VALOR_MAXV`, `VALOR_MINV`, `ANOV`, `ANO`, `MVCODIGOV`, `MRCODIGOV`, `FONE_COM`, `FONE_CEL`, `SEXO`, `CARGO`, `PROFISSAO`, `LIMITECRE`, `LIMITESEC`, `VLRDEBITO`, `CADLOCAL`, `CODINTERN`, `DESFOLHA`, `CLCODPAI`, `DATAALTE`, `DATACADA`, `REFERENCIA`, `SENHA`, `PATHFOTO`, `APCICMS`, `COMPRAATACADO`, `ORGEXPIDEN`, `UFEMIIDEN`, `PRODCODIGO`, `NOMEPAI`, `NOMEMAE`, `DIAFIXPAGAMENTO`, `ADIANTAMENTO`, `FLAGTRANS`, `OBSEXIB`, `CODIBGE`, `CODCONTAB`, `TPENDERECOCOM`, `TPENDERECOCOBR`, `TPENDERECOREC`, `COMPLEMENTOCOM`, `COMPLEMENTOCOBR`, `COMPLEMENTOREC`, `NUMEROCOM`, `NUMEROCOBR`, `NUMEROREC`, `INSCMUN`, `DEDUPIS`, `DEDUCOFINS`, `DEDUCSLL`, `DEDUINSS`, `DEDUISSQN`, `HIST_CLI`, `SUFRAMA`, `NOMEDEP`, `CPFDEPEN`, `DOCDEPEN`, `NOMEDEP2`, `CPFDEPEN2`, `DOCDEPEN2`, `NOMEDEP3`, `CPFDEPEN3`, `DOCDEPEN3`, `ALIQCSLL`, `ALIQINSS`, `ALIQIRRF`) VALUES
(2, 'J', 'MUNICIPIO DE SANTO ANTONIO DO MONTE', '', 'A', 'S', 'GETULIO VARGAS', 'CENTRO', 4558, 'MG', '35560000', '', '', '', '', '', '3732817328', '', '3732817328', '', '', '', '', 2147483647, '', 'ISENTO', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'M', '', '', 100, 0, '', 'T', '', '', '', '2014-10-31 07:05:14', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 12, '', '', '', '', '', '18', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(5, 'J', 'SANTA CASA DE MISERICORDIA SAMONTE', '', 'A', 'S', 'CEL JOSE LUIZ GONCALVES SOBRINHO', 'N SRA FATIMA', 4558, 'MG', '35560000', '', '', '', '', '', '3732818900', '', '', '', '', '', '', 2147483647, '', 'ISENTO', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'M', '', '', 100, 0, '', 'T', '', '', '', '2014-10-31 07:06:36', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 15, '', '', '', '', '', '41', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(7, 'J', 'CAMARA MUNICIPAL DE STO ANTONIO DO MONTE', '', 'A', 'S', 'GETULIO VARGAS', 'CENTRO', 4558, 'MG', '35560000', '', '', '', '', '', '3732812201', '', '', '', '', '', '', 2147483647, '', 'ISENTO', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'M', '', '', 100, 0, '', 'T', '', '', '', '2014-10-31 07:07:03', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 12, '', '', '', '', '', '18', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(9, 'J', 'PANIFICADORA PAO DA VIDA IND COM LTDA', '', 'A', 'S', 'EXPEDICIONARIO GERALDO RESENDE', 'CENTRO', 4558, 'MG', '35560000', '', '', '', '', '', '', '', '', '', '', '', '', 2147483647, '', '6049297100027', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'M', '', '', 100, 0, '', 'T', '', '', '', '2014-10-31 07:13:47', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 12, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(11, 'J', 'APAEA ASSOC PAIS E AMIGOS DO EXCEPCIONAL', '', 'A', 'S', 'DR ARGEMIRO ITAJUBA', 'DOM BOSCO', 4558, 'MG', '35560000', '', '', '', '', '', '3732812493', '', '', '', '', '', '', 2147483647, '', 'ISENTO', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'M', '', '', 100, 0, '', 'T', '', '', '', '2014-10-31 07:23:04', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 15, '', '', '', '', '', '796', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(13, 'J', 'SAMEC STO ANTO MONTE EDUC E CULTURA LTDA', '', 'A', 'S', 'ARISTIDES CABRAL', '', 4558, 'MG', '35560000', '', '', '', '', '', '3732811402', '', '', '', '', '', '', 2147483647, '', 'ISENTO', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'M', '', '', 100, 0, '', 'T', '', '', '', '2014-10-31 08:16:04', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 15, '', '', '', '', '', '123', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(15, 'J', 'CAIXA ECONOMICA FEDERAL', '', 'A', 'S', 'MONSENHOR OTAVIANO', 'CENTRO', 4558, 'MG', '35560000', '', '', '', '', '', '3732815834', '', '', '', '', '', '', 2147483647, '', 'ISENTO', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'M', '', '', 100, 0, '', 'T', '', '', '', '2014-10-31 08:16:23', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 12, '', '', '', '', '', '42', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(18, 'J', 'CAIXA ESCOLAR PADRE PAULO', '', 'A', 'S', 'FRANCISCO TEOTONIO DE CASTRO', 'SAO JOSE', 4558, 'MG', '35560000', '', '', '', '', '', '3732812340', '', '', '', '', '', '', 2147483647, '', 'ISENTO', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'M', '', '', 100, 0, '', 'T', '', '', '', '2014-10-31 08:17:50', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 2, '', '', '', '', '', '1110', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(21, 'J', 'DIAS FOGOS IMPORTA€AO E EXPORTACAO', '', 'A', 'S', 'DOS NOVATOS', 'ZONA RURAL', 4558, 'MG', '35560000', '', '', '', '', '', '', '', '', '', '', '', '', 2147483647, '', '0014266030061', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'M', '', '', 100, 0, '', 'T', '', '', '', '2014-10-31 08:18:16', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 27, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(23, 'J', 'CAIXA ESCOLAR WALDOMIRO M PINTO', '', 'A', 'S', 'DR ARGEMIRO ITAJUBA', 'DOM BOSCO', 4558, 'MG', '35560000', '', '', '', '', '', '3732811587', '', '3732811587', '', '', '', '', 2147483647, '', 'ISENTO', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'M', '', '', 100, 0, '', 'T', '', '', '', '2014-10-31 08:18:33', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 15, '', '', '', '', '', '179', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(26, 'J', 'PREFEITURA MUNICIPAL PEDRA DO INDAIA', '', 'A', 'S', 'PRIMEIRO DE MAR€O', 'CENTRO', 3692, 'MG', '35565000', '', '', '', '', '', '', '', '', '', '', '', '', 2147483647, '', 'ISENTO', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'M', '', '', 100, 0, '', 'T', '', '', '', '2014-10-31 07:24:48', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 2, '', '', '', '', '', '891', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(28, 'J', 'MITRA DIOCESANA DE LUZ P SANTO ANTONIO', '', 'A', 'S', 'DA MATRIZ', 'CENTRO', 4558, 'MG', '35560000', '', '', '', '', '', '3732812852', '', '', '', '', '', '', 2147483647, '', 'ISENTO', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'M', '', '', 100, 0, '', 'T', '', '', '', '2014-10-31 08:19:27', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 12, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(30, 'J', 'TRIBUNAL JUSTICA DO EST MINAS GERAIS', '', 'A', 'S', 'GETULIO VARGAS', 'CENTRO', 4558, 'MG', '35560000', '', '', '', '', '', '', '', '', '', '', '', '', 2147483647, '', 'ISENTO', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'M', '', '', 100, 0, '', 'T', '', '', '', '2014-10-31 08:19:47', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 12, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(34, 'J', 'CAIXA ESCOLAR JUCA PINTO', '', 'A', 'S', 'LUDOVICO HENRIQUE QUIRINO', 'SAO LUCAS', 4558, 'MG', '35560000', '', '', '', '', '', '3732811489', '', '', '', '', '', '', 2147483647, '', 'ISENTO', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'M', '', '', 100, 0, '', 'T', '', '', '', '2014-10-31 08:20:07', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 15, '', '', '', '', '', '285', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(36, 'J', 'CARTORIO PRIMEIRO OFICIO DE NOTAS', '', 'A', 'S', 'MARIA ANGELICA DE CASTRO', 'CENTRO', 4558, 'MG', '35560000', '', '', '', '', '', '3732811728', '', '', '', '', '', '', 2147483647, '', 'ISENTO', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'M', '', '', 100, 0, '', 'T', '', '', '', '2014-10-31 08:20:29', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 15, '', '', '', '', '', '23', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(38, 'J', 'COOP PROD RURAIS SANTO ANT DO MONTE LTDA', '', 'A', 'S', 'ANTONIO BOLINA FILHO', 'SAO GERALDO', 4558, 'MG', '35560000', '', '', '', '', '', '3732812935', '', '', '', '', '', '', 2147483647, '', '6040488840019', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'M', '', '', 100, 0, '', 'T', '', '', '', '2014-10-31 08:20:52', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 2, '', '', '', '', '', '300', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(40, 'J', 'CAIXA E MENINO JESUS SANTO A MONTE PDDE', '', 'A', 'S', 'TENENTE EURIPEDES BATISTA OLIVEIRA', 'CENTRO', 4558, 'MG', '35560000', '', '', '', '', '', '', '', '', '', '', '', '', 2147483647, '', 'ISENTO', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'M', '', '', 100, 0, '', 'T', '', '', '', '2014-10-31 08:21:53', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 15, '', '', '', '', '', '77', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(42, 'J', 'MAQMOL ALTOMACAO COMERCIAL LTDA', '', 'A', 'S', 'SETE SETEMBRO', 'VILA CRUZEIRO', 1575, 'MG', '35500011', '', '', '', '', '', '3732212787', '', '', '', '', '', '', 2147483647, '', '2231882640072', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'M', '', '', 100, 0, '', 'T', '', '', '', '2014-10-31 07:25:47', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 2, '', '', '', '', '', '1780', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(44, 'J', 'LUCRA CADASTROS E SERVICOS LTDA', '', 'A', 'S', 'EXPEDICIONARIO GERALDO RESENDE', 'CENTRO', 4558, 'MG', '35560000', '', '', '', '', '', '', '', '', '', '', '', '', 2147483647, '', 'ISENTO', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'M', '', '', 100, 0, '', 'T', '', '', '', '2014-10-31 07:37:56', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 15, '', '', '', '', '', '25', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(48, 'J', 'UD UTILIDADES DOMESTICAS LTDA', '', 'A', 'S', 'MONSENHOR OTAVIANO', 'CENTRO', 4558, 'MG', '35570000', '', '', '', '', '', '', '', '', '', '', '', '', 2147483647, '', '6049906190250', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'M', '', '', 100, 0, '', 'T', '', '', '', '2014-10-31 07:36:58', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 12, '', '', '', '', '', '100', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(50, 'J', 'CAIXA ESCOLAR DA ESCOLA MUNIC OLINTO PINTO', '', 'A', 'S', 'POVOADO CAPELA DOS NICOS', 'ZONA RURAL', 4558, 'MG', '35560000', '', '', '', '', '', '3732811072', '', '', '', '', '', '', 2147483647, '', 'ISENTO', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'M', '', '', 100, 0, '', 'T', '', '', '', '2014-10-31 07:36:29', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 7, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(52, 'J', 'ELEICAO 2012 COMITE FINANC PSDB S  MONTE', '', 'A', 'S', 'AMERICO PORTELA', 'CENTRO', 4558, 'MG', '35560000', '', '', '', '', '', '', '', '', '', '', '', '', 2147483647, '', 'ISENTO', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'M', '', '', 100, 0, '', 'T', '', '', '', '2014-10-31 07:35:09', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 15, '', '', '', '', '', '349', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(54, 'J', 'CAMARA MUNICIPAL DE PEDRA DO INDAIA', '', 'A', 'S', '1 DE MARCO', 'CENTRO', 3692, 'MG', '35565000', '', '', '', '', '', '3733441455', '', '', '', '', '', '', 2147483647, '', 'ISENTO', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'M', '', '', 100, 0, '', 'T', '', '', '', '2014-10-31 07:34:54', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 2, '', '', '', '', '', '891', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(56, 'J', 'COOPERATIVA EDUCACIONAL MONTENSE LTDA', '', 'A', 'S', 'ARISTIDES CABRAL', 'N SRA FATIMA', 4558, 'MG', '35560000', '', '', '', '', '', '', '', '', '', '', '', '', 2147483647, '', 'ISENTO', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'M', '', '', 100, 0, '', 'T', '', '', '', '2014-10-31 07:34:12', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 15, '', '', '', '', '', '123', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(58, 'J', 'ARMAZEM SANTO ANTONIO LTDA', '', 'A', 'S', 'MONSENHOR OTAVIANO', 'CENTRO', 4558, 'MG', '35560000', '', '', '', '', '', '3732811278', '', '', '', '', '', '', 2147483647, '', '6040735410058', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'M', '', '', 100, 0, '', 'T', '', '', '', '2014-10-31 07:33:22', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 12, '', '', '', '', '', '27', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(60, 'J', 'LAR VICENTINO DE ST ANT DO MONTE', '', 'A', 'S', 'ANTONIO BOLINA FILHO', 'SAO GERALDO', 4558, 'MG', '35560000', '', '', '', '', '', '3732812443', '', '', '', '', '', '', 2147483647, '', 'ISENTO', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'M', '', '', 100, 0, '', 'T', '', '', '', '2014-10-31 07:32:54', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 2, '', '', '', '', '', '299', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(62, 'J', 'ITAU UNIBANCO SA', '', 'A', 'S', 'GOVERNADOR MAGALHAES PINTO', 'N SRA DE FATIMA', 4558, 'MG', '35560000', '', '', '', '', '', '3732811629', '', '', '', '', '', '', 2147483647, '', 'ISENTO', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'M', '', '', 100, 0, '', 'T', '', '', '', '2014-10-31 07:32:38', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 15, '', '', '', '', '', '203', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(64, 'J', 'EMATER MG', '', 'A', 'S', 'BANANAL', 'SANTO ANTONIO', 1575, 'MG', '35560000', '', '', '', '', '', '3732811553', '', '', '', '', '', '', 2147483647, '', '0622022620070', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'M', '', '', 100, 0, '', 'T', '', '', '', '2014-10-31 07:32:20', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 15, '', '', 'SALA 601', '', '', '405', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(66, 'J', 'MICHELE COSMETICOS', '', 'A', 'S', 'OLIMPIO MOREIRA', 'DONA QUITA', 1575, 'MG', '35503390', '', '', '', '', '', '3732220781', '', '', '', '', '', '', 2147483647, '', '2238669520061', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'M', '', '', 100, 0, '', 'T', '', '', '', '2014-10-31 07:32:01', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 15, '', '', '', '', '', '1230', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `devoluca`
--

DROP TABLE IF EXISTS `devoluca`;
CREATE TABLE IF NOT EXISTS `devoluca` (
  `CACODIGO` varchar(50) DEFAULT NULL,
  `DVCODIGO` int(11) DEFAULT NULL,
  `DATA` date DEFAULT NULL,
  `VALDEVOL` double DEFAULT NULL,
  `FUCODIGO` int(11) DEFAULT NULL,
  `PERIODO` int(11) DEFAULT NULL,
  `HORARIO` varchar(50) DEFAULT NULL,
  `HORAINIC` varchar(50) DEFAULT NULL,
  `BAIXAESTO` varchar(50) DEFAULT NULL,
  `FLAGTRANS` varchar(50) DEFAULT NULL,
  `FLAGTSERV` varchar(50) DEFAULT NULL,
  `SETORUSO` varchar(50) DEFAULT NULL,
  `NUREGESP` varchar(50) DEFAULT NULL,
  `NUMEROCOO` int(11) DEFAULT NULL,
  `NUCOOCTVL` int(11) DEFAULT NULL,
  `CLCODIGO` int(11) DEFAULT NULL,
  `TIPO` varchar(50) DEFAULT NULL,
  `CGC` varchar(50) DEFAULT NULL,
  `CPF` varchar(50) DEFAULT NULL,
  `NOME` varchar(50) DEFAULT NULL,
  `TELEFONE` varchar(50) DEFAULT NULL,
  `FANTASIA` varchar(50) DEFAULT NULL,
  `ENDERECO` varchar(50) DEFAULT NULL,
  `TPENDERECOCOM` int(11) DEFAULT NULL,
  `COMPLEMENTOCOM` varchar(50) DEFAULT NULL,
  `NUMEROCOM` int(11) DEFAULT NULL,
  `BAIRRO` varchar(50) DEFAULT NULL,
  `CICODIGO` int(11) DEFAULT NULL,
  `NOMECIDADE` varchar(50) DEFAULT NULL,
  `UF` varchar(50) DEFAULT NULL,
  `CEP` varchar(50) DEFAULT NULL,
  `MODELONF` varchar(50) DEFAULT NULL,
  `SERIENF` varchar(50) DEFAULT NULL,
  `SUBSERIENF` varchar(50) DEFAULT NULL,
  `NUMERONF` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `devoluca`
--

INSERT INTO `devoluca` (`CACODIGO`, `DVCODIGO`, `DATA`, `VALDEVOL`, `FUCODIGO`, `PERIODO`, `HORARIO`, `HORAINIC`, `BAIXAESTO`, `FLAGTRANS`, `FLAGTSERV`, `SETORUSO`, `NUREGESP`, `NUMEROCOO`, `NUCOOCTVL`, `CLCODIGO`, `TIPO`, `CGC`, `CPF`, `NOME`, `TELEFONE`, `FANTASIA`, `ENDERECO`, `TPENDERECOCOM`, `COMPLEMENTOCOM`, `NUMEROCOM`, `BAIRRO`, `CICODIGO`, `NOMECIDADE`, `UF`, `CEP`, `MODELONF`, `SERIENF`, `SUBSERIENF`, `NUMERONF`) VALUES
('C1', 1, '2018-05-23', 2.99, 1, 0, '14:21\n', '', 'S', '', '', '', '', 0, 0, 0, '', '', '', '', '', '', '', 0, '', 0, '', 0, 'MOEMA', '', '', '', '', '', 0),
('C1', 2, '2018-05-23', 2.99, 1, 0, '14:24\n', '', 'S', '', '', '', '', 0, 0, 0, '', '', '', '', '', '', '', 0, '', 0, '', 0, 'MOEMA', '', '', '', '', '', 0);

-- --------------------------------------------------------

--
-- Table structure for table `formpagt`
--

DROP TABLE IF EXISTS `formpagt`;
CREATE TABLE IF NOT EXISTS `formpagt` (
  `FPCODIGO` varchar(30) DEFAULT NULL,
  `NOME` varchar(30) DEFAULT NULL,
  `DIASENTRA` int(11) DEFAULT NULL,
  `PERCENTRA` double DEFAULT NULL,
  `PERCDESCO` double DEFAULT NULL,
  `CODESPEC` int(11) DEFAULT NULL,
  `CLIEOBRIG` varchar(30) DEFAULT NULL,
  `DIASPARC` int(11) DEFAULT NULL,
  `QTDPARC` int(11) DEFAULT NULL,
  `DATAALTE` date DEFAULT NULL,
  `TRATALIM` varchar(30) DEFAULT NULL,
  `PROMISSR` varchar(30) DEFAULT NULL,
  `PEDSENHA` varchar(30) DEFAULT NULL,
  `MAXDESCO` double DEFAULT NULL,
  `MAXPARCE` int(11) DEFAULT NULL,
  `MAXDIASP` int(11) DEFAULT NULL,
  `MAXDIFEP` double DEFAULT NULL,
  `COCODIGO` varchar(30) DEFAULT NULL,
  `CECODIGO` varchar(30) DEFAULT NULL,
  `PLCODIGO` varchar(30) DEFAULT NULL,
  `DESCFIN` double DEFAULT NULL,
  `GERPARDFIXO` varchar(30) DEFAULT NULL,
  `TIPOOPER` varchar(30) DEFAULT NULL,
  `TRANSPOS` varchar(30) DEFAULT NULL,
  `PEDENAUPOS` varchar(30) DEFAULT NULL,
  `TAGTEF` varchar(30) DEFAULT NULL,
  `TPCARTAO` varchar(30) DEFAULT NULL,
  `CODADMIN` varchar(30) DEFAULT NULL,
  `INDPAG` varchar(30) DEFAULT NULL,
  `IMPBOLETO` varchar(30) DEFAULT NULL,
  `TPOPVEICULO` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `formpagt`
--

INSERT INTO `formpagt` (`FPCODIGO`, `NOME`, `DIASENTRA`, `PERCENTRA`, `PERCDESCO`, `CODESPEC`, `CLIEOBRIG`, `DIASPARC`, `QTDPARC`, `DATAALTE`, `TRATALIM`, `PROMISSR`, `PEDSENHA`, `MAXDESCO`, `MAXPARCE`, `MAXDIASP`, `MAXDIFEP`, `COCODIGO`, `CECODIGO`, `PLCODIGO`, `DESCFIN`, `GERPARDFIXO`, `TIPOOPER`, `TRANSPOS`, `PEDENAUPOS`, `TAGTEF`, `TPCARTAO`, `CODADMIN`, `INDPAG`, `IMPBOLETO`, `TPOPVEICULO`) VALUES
('1', 'Venda a Vista', 0, 0, 0, 0, '0', 0, 0, '2018-05-30', 'S', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
('2', 'Venda 30 dias', 0, 0, 0, 0, '0', 0, 30, '2018-05-30', 'S', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `funciona`
--

DROP TABLE IF EXISTS `funciona`;
CREATE TABLE IF NOT EXISTS `funciona` (
  `FUCODIGO` int(11) DEFAULT NULL,
  `NOME` varchar(200) DEFAULT NULL,
  `TFCODIGO` varchar(200) DEFAULT NULL,
  `CPF` varchar(200) DEFAULT NULL,
  `IDENTIDA` varchar(200) DEFAULT NULL,
  `CARTTRAB` varchar(200) DEFAULT NULL,
  `ENDERECO` varchar(200) DEFAULT NULL,
  `BAIRRO` varchar(200) DEFAULT NULL,
  `CICODIGO` int(11) DEFAULT NULL,
  `UF` varchar(200) DEFAULT NULL,
  `CEP` varchar(200) DEFAULT NULL,
  `TELEFONE` varchar(200) DEFAULT NULL,
  `SENHA` varchar(200) DEFAULT NULL,
  `PERCCOMI` double DEFAULT NULL,
  `PERCOMIPRZ` varchar(200) DEFAULT NULL,
  `DATANASC` varchar(200) DEFAULT NULL,
  `FICODIGO` int(11) DEFAULT NULL,
  `EMCODIGO` int(11) DEFAULT NULL,
  `LOCALTRA` varchar(200) DEFAULT NULL,
  `CODINTERN` varchar(200) DEFAULT NULL,
  `DATAALTE` datetime DEFAULT NULL,
  `QHCODIGO` int(11) DEFAULT NULL,
  `ULTIMOAC` datetime DEFAULT NULL,
  `ULTIMOGIRO` int(11) DEFAULT NULL,
  `NIVELATUAL` varchar(200) DEFAULT NULL,
  `RPTSENHA` varchar(200) DEFAULT NULL,
  `PORTEIRO` varchar(200) DEFAULT NULL,
  `DPCODIGO` int(11) DEFAULT NULL,
  `NUMREGISTRO` varchar(200) DEFAULT NULL,
  `DATAEMCART` datetime DEFAULT NULL,
  `SERIECART` varchar(200) DEFAULT NULL,
  `HORAFERIA` varchar(200) DEFAULT NULL,
  `EXTRABFR` varchar(200) DEFAULT NULL,
  `ADMISSAO` datetime DEFAULT NULL,
  `CARGO` varchar(200) DEFAULT NULL,
  `PATHFOTO` varchar(200) DEFAULT NULL,
  `EXTRADEF` varchar(200) DEFAULT NULL,
  `PERMITEAGENDA` varchar(200) DEFAULT NULL,
  `CODFRENTI` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `funciona`
--

INSERT INTO `funciona` (`FUCODIGO`, `NOME`, `TFCODIGO`, `CPF`, `IDENTIDA`, `CARTTRAB`, `ENDERECO`, `BAIRRO`, `CICODIGO`, `UF`, `CEP`, `TELEFONE`, `SENHA`, `PERCCOMI`, `PERCOMIPRZ`, `DATANASC`, `FICODIGO`, `EMCODIGO`, `LOCALTRA`, `CODINTERN`, `DATAALTE`, `QHCODIGO`, `ULTIMOAC`, `ULTIMOGIRO`, `NIVELATUAL`, `RPTSENHA`, `PORTEIRO`, `DPCODIGO`, `NUMREGISTRO`, `DATAEMCART`, `SERIECART`, `HORAFERIA`, `EXTRABFR`, `ADMISSAO`, `CARGO`, `PATHFOTO`, `EXTRADEF`, `PERMITEAGENDA`, `CODFRENTI`) VALUES
(1, 'USUARIO', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `itemdevo`
--

DROP TABLE IF EXISTS `itemdevo`;
CREATE TABLE IF NOT EXISTS `itemdevo` (
  `CACODIGO` varchar(30) DEFAULT NULL,
  `DVCODIGO` int(11) DEFAULT NULL,
  `NUMITEM` int(11) DEFAULT NULL,
  `MFCODIGO` varchar(30) DEFAULT NULL,
  `PLCODIGO` varchar(30) DEFAULT NULL,
  `QTDITEM` double DEFAULT NULL,
  `VALITEM` double DEFAULT NULL,
  `FUCODIGO` int(11) DEFAULT NULL,
  `FUCODLAN` int(11) DEFAULT NULL,
  `ALIQICMS` double DEFAULT NULL,
  `CODTRIB` varchar(30) DEFAULT NULL,
  `NUMDOCUM` varchar(30) DEFAULT NULL,
  `PRCUNIT` double DEFAULT NULL,
  `MMFCODIGO` varchar(30) DEFAULT NULL,
  `NOME` varchar(30) DEFAULT NULL,
  `UNCODIGO` varchar(30) DEFAULT NULL,
  `PRECOVEN` double DEFAULT NULL,
  `MALIQICMS` double DEFAULT NULL,
  `CODORIGE` varchar(30) DEFAULT NULL,
  `MCODTRIB` varchar(30) DEFAULT NULL,
  `PESAVEL` varchar(30) DEFAULT NULL,
  `ALIQIPI` double DEFAULT NULL,
  `CODEXTRA` varchar(30) DEFAULT NULL,
  `REFERENCI` varchar(30) DEFAULT NULL,
  `GRADE` varchar(30) DEFAULT NULL,
  `COR` varchar(30) DEFAULT NULL,
  `TAMANHO` varchar(30) DEFAULT NULL,
  `CODINTERN` varchar(30) DEFAULT NULL,
  `TIPOTRIBU` varchar(30) DEFAULT NULL,
  `PRECOVEN1` double DEFAULT NULL,
  `QTDESTOQ` double DEFAULT NULL,
  `PATHFOTO` varchar(30) DEFAULT NULL,
  `AGCODIGO` varchar(30) DEFAULT NULL,
  `EXCLUIDO` varchar(30) DEFAULT NULL,
  `FLAGTRANS` varchar(30) DEFAULT NULL,
  `FLAGTSERV` varchar(30) DEFAULT NULL,
  `DEPROTOT` double DEFAULT NULL,
  `ACPROTOT` double DEFAULT NULL,
  `COMPOSTO` varchar(30) DEFAULT NULL,
  `CACODORI` varchar(30) DEFAULT NULL,
  `SETORORI` varchar(30) DEFAULT NULL,
  `CODRECEI` varchar(30) DEFAULT NULL,
  `HORARECE` varchar(30) DEFAULT NULL,
  `QTDRECEI` double DEFAULT NULL,
  `TIPOFAB` varchar(30) DEFAULT NULL,
  `IAT` varchar(30) DEFAULT NULL,
  `CACODCUP` varchar(30) DEFAULT NULL,
  `VDCODIGO` int(11) DEFAULT NULL,
  `ITEMVEND` int(11) DEFAULT NULL,
  `DATAHORACUP` date DEFAULT NULL,
  `DATACUP` date DEFAULT NULL,
  `NUMCUPOM` int(11) DEFAULT NULL,
  `NUMCOOCUP` int(11) DEFAULT NULL,
  `DTMOVCUP` date DEFAULT NULL,
  `ECFSERIEVND` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `itemdevo`
--

INSERT INTO `itemdevo` (`CACODIGO`, `DVCODIGO`, `NUMITEM`, `MFCODIGO`, `PLCODIGO`, `QTDITEM`, `VALITEM`, `FUCODIGO`, `FUCODLAN`, `ALIQICMS`, `CODTRIB`, `NUMDOCUM`, `PRCUNIT`, `MMFCODIGO`, `NOME`, `UNCODIGO`, `PRECOVEN`, `MALIQICMS`, `CODORIGE`, `MCODTRIB`, `PESAVEL`, `ALIQIPI`, `CODEXTRA`, `REFERENCI`, `GRADE`, `COR`, `TAMANHO`, `CODINTERN`, `TIPOTRIBU`, `PRECOVEN1`, `QTDESTOQ`, `PATHFOTO`, `AGCODIGO`, `EXCLUIDO`, `FLAGTRANS`, `FLAGTSERV`, `DEPROTOT`, `ACPROTOT`, `COMPOSTO`, `CACODORI`, `SETORORI`, `CODRECEI`, `HORARECE`, `QTDRECEI`, `TIPOFAB`, `IAT`, `CACODCUP`, `VDCODIGO`, `ITEMVEND`, `DATAHORACUP`, `DATACUP`, `NUMCUPOM`, `NUMCOOCUP`, `DTMOVCUP`, `ECFSERIEVND`) VALUES
('C1', 1, 1, '11', '12', 1, 2.99, 1, 1, 0, '1', '', 2.99, '11', 'PRODUTO 1', '1', 2.99, 0, '110', '', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2.99, 0, NULL, NULL, 'N', 'N', 'N', 0, 0, NULL, 'C1', '', '', '', 0, NULL, NULL, '', NULL, 0, '2018-05-23', '2018-05-23', 0, 0, '2018-05-23', ''),
('C1', 2, 1, '11', '12', 1, 2.99, 1, 1, 0, '1', '', 2.99, '11', 'PRODUTO 1', '1', 2.99, 0, '110', '', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2.99, 0, NULL, NULL, 'N', 'N', 'N', 0, 0, NULL, 'C1', '', '', '', 0, NULL, NULL, '', NULL, 0, '2018-05-23', '2018-05-23', 0, 0, '2018-05-23', ''),
('C1', 3, 1, '11', '12', 1, 2.99, 1, 1, 0, '1', '', 2.99, '11', 'PRODUTO 1', '1', 2.99, 0, '110', '', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2.99, 0, NULL, NULL, 'N', 'N', 'N', 0, 0, NULL, 'C1', '', '', '', 0, NULL, NULL, '', NULL, 0, '2018-05-23', '2018-05-23', 0, 0, '2018-05-23', '');

-- --------------------------------------------------------

--
-- Table structure for table `itemvpdv`
--

DROP TABLE IF EXISTS `itemvpdv`;
CREATE TABLE IF NOT EXISTS `itemvpdv` (
  `CACODIGO` varchar(30) DEFAULT NULL,
  `VDCODIGO` int(11) DEFAULT NULL,
  `NUMITEM` int(11) DEFAULT NULL,
  `MFCODIGO` varchar(30) DEFAULT NULL,
  `PLCODIGO` varchar(30) DEFAULT NULL,
  `QTDITEM` double DEFAULT NULL,
  `VALITEM` double DEFAULT NULL,
  `FUCODIGO` int(11) DEFAULT NULL,
  `FUCODLAN` int(11) DEFAULT NULL,
  `FUCODDES` int(11) DEFAULT NULL,
  `SEQTOTECF` varchar(30) DEFAULT NULL,
  `ALIQICMS` double DEFAULT NULL,
  `CODTRIB` varchar(30) DEFAULT NULL,
  `DESCTRIB` varchar(30) DEFAULT NULL,
  `NUMDOCUM` varchar(30) DEFAULT NULL,
  `PRCUNIT` double DEFAULT NULL,
  `MMFCODIGO` varchar(30) DEFAULT NULL,
  `NOME` varchar(30) DEFAULT NULL,
  `UNCODIGO` varchar(30) DEFAULT NULL,
  `PRECOVEN` double DEFAULT NULL,
  `MALIQICMS` double DEFAULT NULL,
  `CODORIGE` varchar(30) DEFAULT NULL,
  `MCODTRIB` varchar(30) DEFAULT NULL,
  `PESAVEL` varchar(30) DEFAULT NULL,
  `ALIQIPI` double DEFAULT NULL,
  `CODEXTRA` varchar(30) DEFAULT NULL,
  `REFERENCI` varchar(30) DEFAULT NULL,
  `GRADE` varchar(30) DEFAULT NULL,
  `COR` varchar(30) DEFAULT NULL,
  `TAMANHO` varchar(30) DEFAULT NULL,
  `CODINTERN` varchar(30) DEFAULT NULL,
  `TIPOTRIBU` varchar(30) DEFAULT NULL,
  `PRECOVEN1` double DEFAULT NULL,
  `QTDESTOQ` double DEFAULT NULL,
  `PATHFOTO` varchar(30) DEFAULT NULL,
  `AGCODIGO` varchar(30) DEFAULT NULL,
  `EXCLUIDO` varchar(30) DEFAULT NULL,
  `FLAGTRANS` varchar(30) DEFAULT NULL,
  `FLAGTSERV` varchar(30) DEFAULT NULL,
  `DEPROTOT` double DEFAULT NULL,
  `ACPROTOT` double DEFAULT NULL,
  `COMPOSTO` varchar(30) DEFAULT NULL,
  `CACODORI` varchar(30) DEFAULT NULL,
  `SETORORI` varchar(30) DEFAULT NULL,
  `CODRECEI` varchar(30) DEFAULT NULL,
  `HORARECE` varchar(30) DEFAULT NULL,
  `QTDRECEI` double DEFAULT NULL,
  `COMANDAOK` varchar(30) DEFAULT NULL,
  `DATACOMA` date DEFAULT NULL,
  `TIPOFAB` varchar(30) DEFAULT NULL,
  `IAT` varchar(30) DEFAULT NULL,
  `MESAORITR` int(11) DEFAULT NULL,
  `MBCODIGO` int(11) DEFAULT NULL,
  `TQCODIGO` varchar(30) DEFAULT NULL,
  `BMCODIGO` varchar(30) DEFAULT NULL,
  `BICODIGO` varchar(30) DEFAULT NULL,
  `DESCBICO` varchar(30) DEFAULT NULL,
  `ENCINICI` double DEFAULT NULL,
  `ENCFINAL` double DEFAULT NULL,
  `CARTAOPAS` varchar(30) DEFAULT NULL,
  `POSIMESA` varchar(30) DEFAULT NULL,
  `CVCODIGO` varchar(30) DEFAULT NULL,
  `VASPARTIDA` varchar(30) DEFAULT NULL,
  `VASVENCIME` varchar(30) DEFAULT NULL,
  `VASTIPO` varchar(30) DEFAULT NULL,
  `VASFOCODIG` int(11) DEFAULT NULL,
  `VASCODPROD` varchar(30) DEFAULT NULL,
  `VASNOMECID` varchar(30) DEFAULT NULL,
  `ORIGEM` varchar(30) DEFAULT NULL,
  `MECODIGO` int(11) DEFAULT NULL,
  `PRECOCUS` double DEFAULT NULL,
  `PRCCUMED` double DEFAULT NULL,
  `PRCCUCON` double DEFAULT NULL,
  `PRCCUMEC` double DEFAULT NULL,
  `PRECOREF` double DEFAULT NULL,
  `ECFSERIE` varchar(30) DEFAULT NULL,
  `NUMEROCOO` int(11) DEFAULT NULL,
  `NUMCUPOM` int(11) DEFAULT NULL,
  `PAFINDCANC` varchar(30) DEFAULT NULL,
  `MODELODOC` varchar(30) DEFAULT NULL,
  `PAFHASHVER` varchar(30) DEFAULT NULL,
  `PAFHASHDET` varchar(30) DEFAULT NULL,
  `CSTPIS` varchar(30) DEFAULT NULL,
  `VLRBCPIS` double DEFAULT NULL,
  `ALIQPIS` double DEFAULT NULL,
  `VALORPIS` double DEFAULT NULL,
  `VLRPISST` double DEFAULT NULL,
  `CSTCOFIN` varchar(5) DEFAULT NULL,
  `VLRBCCFS` double DEFAULT NULL,
  `ALIQCFS` double DEFAULT NULL,
  `VALORCFS` double DEFAULT NULL,
  `VLRCFSST` double DEFAULT NULL,
  `NUMITEMDAV` int(11) DEFAULT NULL,
  `DATADAMOV` date DEFAULT NULL,
  `ECFSEQUE` varchar(30) DEFAULT NULL,
  `ECFMARCA` varchar(30) DEFAULT NULL,
  `ECFMODELO` varchar(30) DEFAULT NULL,
  `ECFTIPO` varchar(30) DEFAULT NULL,
  `SWBVERSAO` varchar(30) DEFAULT NULL,
  `SWBDTHRGR` date DEFAULT NULL,
  `SWBMFADIC` varchar(30) DEFAULT NULL,
  `ARCODIGO` int(11) DEFAULT NULL,
  `QTDDEVOL` double DEFAULT NULL,
  `DADOMAQU` varchar(30) DEFAULT NULL,
  `HORAPEDI` date DEFAULT NULL,
  `DESCCOMP` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `itemvpdv`
--

INSERT INTO `itemvpdv` (`CACODIGO`, `VDCODIGO`, `NUMITEM`, `MFCODIGO`, `PLCODIGO`, `QTDITEM`, `VALITEM`, `FUCODIGO`, `FUCODLAN`, `FUCODDES`, `SEQTOTECF`, `ALIQICMS`, `CODTRIB`, `DESCTRIB`, `NUMDOCUM`, `PRCUNIT`, `MMFCODIGO`, `NOME`, `UNCODIGO`, `PRECOVEN`, `MALIQICMS`, `CODORIGE`, `MCODTRIB`, `PESAVEL`, `ALIQIPI`, `CODEXTRA`, `REFERENCI`, `GRADE`, `COR`, `TAMANHO`, `CODINTERN`, `TIPOTRIBU`, `PRECOVEN1`, `QTDESTOQ`, `PATHFOTO`, `AGCODIGO`, `EXCLUIDO`, `FLAGTRANS`, `FLAGTSERV`, `DEPROTOT`, `ACPROTOT`, `COMPOSTO`, `CACODORI`, `SETORORI`, `CODRECEI`, `HORARECE`, `QTDRECEI`, `COMANDAOK`, `DATACOMA`, `TIPOFAB`, `IAT`, `MESAORITR`, `MBCODIGO`, `TQCODIGO`, `BMCODIGO`, `BICODIGO`, `DESCBICO`, `ENCINICI`, `ENCFINAL`, `CARTAOPAS`, `POSIMESA`, `CVCODIGO`, `VASPARTIDA`, `VASVENCIME`, `VASTIPO`, `VASFOCODIG`, `VASCODPROD`, `VASNOMECID`, `ORIGEM`, `MECODIGO`, `PRECOCUS`, `PRCCUMED`, `PRCCUCON`, `PRCCUMEC`, `PRECOREF`, `ECFSERIE`, `NUMEROCOO`, `NUMCUPOM`, `PAFINDCANC`, `MODELODOC`, `PAFHASHVER`, `PAFHASHDET`, `CSTPIS`, `VLRBCPIS`, `ALIQPIS`, `VALORPIS`, `VLRPISST`, `CSTCOFIN`, `VLRBCCFS`, `ALIQCFS`, `VALORCFS`, `VLRCFSST`, `NUMITEMDAV`, `DATADAMOV`, `ECFSEQUE`, `ECFMARCA`, `ECFMODELO`, `ECFTIPO`, `SWBVERSAO`, `SWBDTHRGR`, `SWBMFADIC`, `ARCODIGO`, `QTDDEVOL`, `DADOMAQU`, `HORAPEDI`, `DESCCOMP`) VALUES
('C1', 1, 1, '10', '12', 1, 2.99, 1, 1, 0, '', 0, '1', '', '', 2.99, '10', 'PRODUTO 1', '1', 2.99, 0, '10', '', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2.99, 0, NULL, NULL, 'N', 'N', 'N', 0, 0, NULL, 'C1', '', '', '', 0, 'N', NULL, NULL, NULL, 0, 0, '', '', '', '', 0, 0, '', '', '', '', '', '', 0, '', '', 'MOVIM', 0, 4, 10, 6, 0, 0, 'X2', 0, 0, '', '', '', '', '', 0, 0, 0, 0, '', 0, 0, 0, 0, 0, '2018-05-22', '', '', '', '', '', NULL, 'N', 0, 0, '', NULL, ''),
('C1', 2, 1, '11', '12', 1, 2.99, 1, 1, 0, '', 0, '1', '', '', 2.99, '11', 'PRODUTO 1', '1', 2.99, 0, '110', '', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2.99, 0, NULL, NULL, 'N', 'N', 'N', 0, 0, NULL, 'C1', '', '', '', 0, 'N', NULL, NULL, NULL, 0, 0, '', '', '', '', 0, 0, '', '', '', '', '', '', 0, '', '', 'MOVIM', 0, 4, 10, 6, 0, 0, 'X2', 0, 0, '', '', '', '', '', 0, 0, 0, 0, '', 0, 0, 0, 0, 0, '2018-05-22', '', '', '', '', '', NULL, 'N', 0, 0, '', NULL, ''),
('C1', 3, 1, '11', '12', 1, 2.99, 1, 1, 0, '', 0, '1', '', '', 2.99, '11', 'PRODUTO 1', '1', 2.99, 0, '110', '', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2.99, 0, NULL, NULL, 'N', 'N', 'N', 0, 0, NULL, 'C1', '', '', '', 0, 'N', NULL, NULL, NULL, 0, 0, '', '', '', '', 0, 0, '', '', '', '', '', '', 0, '', '', 'MOVIM', 0, 4, 10, 6, 0, 0, 'X2', 0, 0, '', '', '', '', '', 0, 0, 0, 0, '', 0, 0, 0, 0, 0, '2018-05-22', '', '', '', '', '', NULL, 'N', 0, 0, '', NULL, ''),
('C1', 4, 1, '11', '12', 1, 2.99, 1, 1, 0, '', 0, '1', '', '', 2.99, '11', 'PRODUTO 1', '1', 2.99, 0, '110', '', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2.99, 0, NULL, NULL, 'N', 'N', 'N', 0, 0, NULL, 'C1', '', '', '', 0, 'N', NULL, NULL, NULL, 0, 0, '', '', '', '', 0, 0, '', '', '', '', '', '', 0, '', '', 'MOVIM', 0, 4, 10, 6, 0, 0, 'X2', 0, 0, '', '', '', '', '', 0, 0, 0, 0, '', 0, 0, 0, 0, 0, '2018-05-22', '', '', '', '', '', NULL, 'N', 0, 0, '', NULL, '');

-- --------------------------------------------------------

--
-- Table structure for table `iteorcam`
--

DROP TABLE IF EXISTS `iteorcam`;
CREATE TABLE IF NOT EXISTS `iteorcam` (
  `ORCODIGO` int(11) DEFAULT NULL,
  `NUMITEM` int(11) DEFAULT NULL,
  `DAV` int(11) DEFAULT NULL,
  `MFCODIGO` varchar(40) DEFAULT NULL,
  `NOME` varchar(40) DEFAULT NULL,
  `UNCODIGO` varchar(40) DEFAULT NULL,
  `ALIQICMS` double DEFAULT NULL,
  `CODTRIB` varchar(40) DEFAULT NULL,
  `DESCTRIB` varchar(40) DEFAULT NULL,
  `QTDITEM` double DEFAULT NULL,
  `PRCUNIT` double DEFAULT NULL,
  `VALITEM` double DEFAULT NULL,
  `ALIQIPI` double DEFAULT NULL,
  `QTDRET` double DEFAULT NULL,
  `VALRET` double DEFAULT NULL,
  `FUCODIGO` int(11) DEFAULT NULL,
  `TIPOTRIBU` varchar(40) DEFAULT NULL,
  `DESCONTO` double DEFAULT NULL,
  `PERCDESC` double DEFAULT NULL,
  `ACRESCIMO` double DEFAULT NULL,
  `PERCACRES` double DEFAULT NULL,
  `FLAGTRANS` varchar(40) DEFAULT NULL,
  `SERVMUN` varchar(40) DEFAULT NULL,
  `FUAUTOR` int(11) DEFAULT NULL,
  `DEPROTOT` double DEFAULT NULL,
  `ACPROTOT` double DEFAULT NULL,
  `EXCLUIDO` varchar(40) DEFAULT NULL,
  `DATAALTE` date DEFAULT NULL,
  `DATAINCL` date DEFAULT NULL,
  `QTDPECAS` double DEFAULT NULL,
  `DIAMETRO` double DEFAULT NULL,
  `OBS` varchar(100) DEFAULT NULL,
  `COMPRIMENTO` double DEFAULT NULL,
  `HORAPEDI` double DEFAULT NULL,
  `DESCCOMP` varchar(40) DEFAULT NULL,
  `PAFHASHVER` varchar(40) DEFAULT NULL,
  `PAFHASHDET` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `iteorcam`
--

INSERT INTO `iteorcam` (`ORCODIGO`, `NUMITEM`, `DAV`, `MFCODIGO`, `NOME`, `UNCODIGO`, `ALIQICMS`, `CODTRIB`, `DESCTRIB`, `QTDITEM`, `PRCUNIT`, `VALITEM`, `ALIQIPI`, `QTDRET`, `VALRET`, `FUCODIGO`, `TIPOTRIBU`, `DESCONTO`, `PERCDESC`, `ACRESCIMO`, `PERCACRES`, `FLAGTRANS`, `SERVMUN`, `FUAUTOR`, `DEPROTOT`, `ACPROTOT`, `EXCLUIDO`, `DATAALTE`, `DATAINCL`, `QTDPECAS`, `DIAMETRO`, `OBS`, `COMPRIMENTO`, `HORAPEDI`, `DESCCOMP`, `PAFHASHVER`, `PAFHASHDET`) VALUES
(1, 1, 0, '10', 'PRODUTO 1', '1', 0, '1', '', 1, 2.99, 2.99, 0, 0, 0, 1, NULL, 0, 0, 0, 0, '', '', 0, 0, 0, '', NULL, '2018-05-22', 0, 0, NULL, 0, NULL, '', '', ''),
(2, 1, 0, '11', 'PRODUTO 1', '1', 0, '1', '', 1, 2.99, 2.99, 0, 0, 0, 1, NULL, 0, 0, 0, 0, '', '', 0, 0, 0, '', NULL, '2018-05-22', 0, 0, NULL, 0, NULL, '', '', ''),
(3, 1, 0, '11', 'PRODUTO 1', '1', 0, '1', '', 1, 2.99, 2.99, 0, 0, 0, 1, NULL, 0, 0, 0, 0, '', '', 0, 0, 0, '', NULL, '2018-05-22', 0, 0, NULL, 0, NULL, '', '', ''),
(4, 1, 0, '11', 'PRODUTO 1', '1', 0, '1', '', 1, 2.99, 2.99, 0, 0, 0, 1, NULL, 0, 0, 0, 0, '', '', 0, 0, 0, '', NULL, '2018-05-22', 0, 0, NULL, 0, NULL, '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `itprvpdv`
--

DROP TABLE IF EXISTS `itprvpdv`;
CREATE TABLE IF NOT EXISTS `itprvpdv` (
  `VDCODIGO` int(11) DEFAULT NULL,
  `NUMITEM` int(11) DEFAULT NULL,
  `CACODIGO` varchar(30) DEFAULT NULL,
  `MFCODIGO` varchar(30) DEFAULT NULL,
  `PLCODIGO` varchar(30) DEFAULT NULL,
  `QTDITEM` double DEFAULT NULL,
  `VALITEM` double DEFAULT NULL,
  `FUCODIGO` int(11) DEFAULT NULL,
  `FUCODLAN` int(11) DEFAULT NULL,
  `FUCODDES` int(11) DEFAULT NULL,
  `SEQTOTECF` varchar(30) DEFAULT NULL,
  `ALIQICMS` double DEFAULT NULL,
  `CODTRIB` varchar(30) DEFAULT NULL,
  `DESCTRIB` varchar(30) DEFAULT NULL,
  `NUMDOCUM` varchar(30) DEFAULT NULL,
  `PRCUNIT` double DEFAULT NULL,
  `PRECOSUBPC` double DEFAULT NULL,
  `PRECOSUBMS` double DEFAULT NULL,
  `MMFCODIGO` varchar(30) DEFAULT NULL,
  `NOME` varchar(30) DEFAULT NULL,
  `UNCODIGO` varchar(30) DEFAULT NULL,
  `PRECOVEN` double DEFAULT NULL,
  `MALIQICMS` double DEFAULT NULL,
  `CODORIGE` varchar(30) DEFAULT NULL,
  `MCODTRIB` varchar(30) DEFAULT NULL,
  `PESAVEL` varchar(30) DEFAULT NULL,
  `ALIQIPI` double DEFAULT NULL,
  `CODEXTRA` varchar(30) DEFAULT NULL,
  `REFERENCI` varchar(30) DEFAULT NULL,
  `GRADE` varchar(30) DEFAULT NULL,
  `COR` varchar(30) DEFAULT NULL,
  `TAMANHO` varchar(30) DEFAULT NULL,
  `CODINTERN` varchar(30) DEFAULT NULL,
  `TIPOTRIBU` varchar(30) DEFAULT NULL,
  `PRECOVEN1` double DEFAULT NULL,
  `QTDESTOQ` double DEFAULT NULL,
  `PATHFOTO` varchar(30) DEFAULT NULL,
  `AGCODIGO` varchar(30) DEFAULT NULL,
  `EXCLUIDO` varchar(30) DEFAULT NULL,
  `FLAGTRANS` varchar(30) DEFAULT NULL,
  `DEPROTOT` double DEFAULT NULL,
  `ACPROTOT` double DEFAULT NULL,
  `COMPOSTO` varchar(30) DEFAULT NULL,
  `CACODORI` varchar(30) DEFAULT NULL,
  `SETORORI` varchar(30) DEFAULT NULL,
  `CODRECEI` varchar(30) DEFAULT NULL,
  `HORARECE` varchar(30) DEFAULT NULL,
  `QTDRECEI` double DEFAULT NULL,
  `COMANDAOK` varchar(30) DEFAULT NULL,
  `DATACOMA` date DEFAULT NULL,
  `TIPOFAB` varchar(30) DEFAULT NULL,
  `IAT` varchar(30) DEFAULT NULL,
  `MESAORITR` int(11) DEFAULT NULL,
  `MBCODIGO` int(11) DEFAULT NULL,
  `TQCODIGO` varchar(30) DEFAULT NULL,
  `BMCODIGO` varchar(30) DEFAULT NULL,
  `BICODIGO` varchar(30) DEFAULT NULL,
  `DESCBICO` varchar(30) DEFAULT NULL,
  `ENCINICI` double DEFAULT NULL,
  `ENCFINAL` double DEFAULT NULL,
  `CARTAOPAS` varchar(30) DEFAULT NULL,
  `POSIMESA` varchar(30) DEFAULT NULL,
  `CVCODIGO` varchar(30) DEFAULT NULL,
  `VASPARTIDA` varchar(30) DEFAULT NULL,
  `VASVENCIME` varchar(30) DEFAULT NULL,
  `VASTIPO` varchar(30) DEFAULT NULL,
  `VASFOCODIG` int(11) DEFAULT NULL,
  `VASCODPROD` varchar(30) DEFAULT NULL,
  `VASNOMECID` varchar(30) DEFAULT NULL,
  `ORIGEM` varchar(30) DEFAULT NULL,
  `MECODIGO` int(11) DEFAULT NULL,
  `PRECOCUS` double DEFAULT NULL,
  `PRCCUMED` double DEFAULT NULL,
  `PRCCUCON` double DEFAULT NULL,
  `PRCCUMEC` double DEFAULT NULL,
  `PRECOREF` double DEFAULT NULL,
  `ECFSERIE` varchar(30) DEFAULT NULL,
  `NUMEROCOO` int(11) DEFAULT NULL,
  `NUMCUPOM` int(11) DEFAULT NULL,
  `PAFINDCANC` varchar(30) DEFAULT NULL,
  `MODELODOC` varchar(30) DEFAULT NULL,
  `PAFHASHVER` varchar(30) DEFAULT NULL,
  `PAFHASHDET` varchar(30) DEFAULT NULL,
  `CSTPIS` varchar(30) DEFAULT NULL,
  `VLRBCPIS` double DEFAULT NULL,
  `ALIQPIS` double DEFAULT NULL,
  `VALORPIS` double DEFAULT NULL,
  `VLRPISST` double DEFAULT NULL,
  `CSTCOFIN` varchar(30) DEFAULT NULL,
  `VLRBCCFS` double DEFAULT NULL,
  `ALIQCFS` double DEFAULT NULL,
  `VALORCFS` double DEFAULT NULL,
  `VLRCFSST` double DEFAULT NULL,
  `NUMITEMDAV` int(11) DEFAULT NULL,
  `DATADAMOV` date DEFAULT NULL,
  `ECFSEQUE` varchar(30) DEFAULT NULL,
  `ECFMARCA` varchar(30) DEFAULT NULL,
  `ECFMODELO` varchar(30) DEFAULT NULL,
  `ECFTIPO` varchar(30) DEFAULT NULL,
  `SWBVERSAO` varchar(30) DEFAULT NULL,
  `SWBDTHRGR` date DEFAULT NULL,
  `SWBMFADIC` varchar(30) DEFAULT NULL,
  `ARCODIGO` int(11) DEFAULT NULL,
  `DADOMAQU` varchar(30) DEFAULT NULL,
  `HORAPEDI` date DEFAULT NULL,
  `DESCCOMP` varchar(30) DEFAULT NULL,
  `QTDMEDSOLIC` double DEFAULT NULL,
  `QTDMEDAUTOR` double DEFAULT NULL,
  `STSPROC` varchar(30) DEFAULT NULL,
  `MSGPROC` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `itprvpdv`
--

INSERT INTO `itprvpdv` (`VDCODIGO`, `NUMITEM`, `CACODIGO`, `MFCODIGO`, `PLCODIGO`, `QTDITEM`, `VALITEM`, `FUCODIGO`, `FUCODLAN`, `FUCODDES`, `SEQTOTECF`, `ALIQICMS`, `CODTRIB`, `DESCTRIB`, `NUMDOCUM`, `PRCUNIT`, `PRECOSUBPC`, `PRECOSUBMS`, `MMFCODIGO`, `NOME`, `UNCODIGO`, `PRECOVEN`, `MALIQICMS`, `CODORIGE`, `MCODTRIB`, `PESAVEL`, `ALIQIPI`, `CODEXTRA`, `REFERENCI`, `GRADE`, `COR`, `TAMANHO`, `CODINTERN`, `TIPOTRIBU`, `PRECOVEN1`, `QTDESTOQ`, `PATHFOTO`, `AGCODIGO`, `EXCLUIDO`, `FLAGTRANS`, `DEPROTOT`, `ACPROTOT`, `COMPOSTO`, `CACODORI`, `SETORORI`, `CODRECEI`, `HORARECE`, `QTDRECEI`, `COMANDAOK`, `DATACOMA`, `TIPOFAB`, `IAT`, `MESAORITR`, `MBCODIGO`, `TQCODIGO`, `BMCODIGO`, `BICODIGO`, `DESCBICO`, `ENCINICI`, `ENCFINAL`, `CARTAOPAS`, `POSIMESA`, `CVCODIGO`, `VASPARTIDA`, `VASVENCIME`, `VASTIPO`, `VASFOCODIG`, `VASCODPROD`, `VASNOMECID`, `ORIGEM`, `MECODIGO`, `PRECOCUS`, `PRCCUMED`, `PRCCUCON`, `PRCCUMEC`, `PRECOREF`, `ECFSERIE`, `NUMEROCOO`, `NUMCUPOM`, `PAFINDCANC`, `MODELODOC`, `PAFHASHVER`, `PAFHASHDET`, `CSTPIS`, `VLRBCPIS`, `ALIQPIS`, `VALORPIS`, `VLRPISST`, `CSTCOFIN`, `VLRBCCFS`, `ALIQCFS`, `VALORCFS`, `VLRCFSST`, `NUMITEMDAV`, `DATADAMOV`, `ECFSEQUE`, `ECFMARCA`, `ECFMODELO`, `ECFTIPO`, `SWBVERSAO`, `SWBDTHRGR`, `SWBMFADIC`, `ARCODIGO`, `DADOMAQU`, `HORAPEDI`, `DESCCOMP`, `QTDMEDSOLIC`, `QTDMEDAUTOR`, `STSPROC`, `MSGPROC`) VALUES
(1, 1, 'C1', '11', '12', 1, 2.99, 1, 1, 0, '', 0, '1', '', '', 2.99, 0, 0, '11', 'PRODUTO 1', '1', 2.99, 0, '110', '', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2.99, 0, NULL, NULL, 'N', 'N', 0, 0, NULL, 'C1', '', '', '', 0, 'N', NULL, NULL, NULL, 0, 0, '', '', '', '', 0, 0, '', '', '', '', '', '', 0, '', '', 'MOVIM', 0, 4, 10, 6, 0, 0, 'X2', 0, 0, '', '', '', '', '', 0, 0, 0, 0, '', 0, 0, 0, 0, 0, '2018-05-22', '', '', '', '', '', NULL, 'N', 0, '', NULL, '', 0, 0, '', '');

-- --------------------------------------------------------

--
-- Table structure for table `lancamen`
--

DROP TABLE IF EXISTS `lancamen`;
CREATE TABLE IF NOT EXISTS `lancamen` (
  `LACODIGO` int(11) DEFAULT NULL,
  `COCODIGO` varchar(50) DEFAULT NULL,
  `CECODIGO` varchar(50) DEFAULT NULL,
  `PLCODIGO` varchar(50) DEFAULT NULL,
  `TIPO` varchar(50) DEFAULT NULL,
  `DATALANC` date DEFAULT NULL,
  `DATAVENC` date DEFAULT NULL,
  `DATAEMBO` date DEFAULT NULL,
  `VALORANT` double DEFAULT NULL,
  `MOEDAANT` varchar(50) DEFAULT NULL,
  `MULTA` double DEFAULT NULL,
  `JUROS` double DEFAULT NULL,
  `DESCONTO` double DEFAULT NULL,
  `VALOR` double DEFAULT NULL,
  `MOCODIGO` varchar(50) DEFAULT NULL,
  `DATAQUIT` date DEFAULT NULL,
  `CLCODIGO` int(11) DEFAULT NULL,
  `FOCODIGO` int(11) DEFAULT NULL,
  `NUMCHEQ` varchar(50) DEFAULT NULL,
  `NUMDUPL` varchar(50) DEFAULT NULL,
  `MODELONF` varchar(50) DEFAULT NULL,
  `SUBSERIENF` varchar(50) DEFAULT NULL,
  `NUMERONF` int(11) DEFAULT NULL,
  `SERIENF` varchar(50) DEFAULT NULL,
  `VECODIGO` int(11) DEFAULT NULL,
  `OBS` varchar(50) DEFAULT NULL,
  `EMCODIGO` int(11) DEFAULT NULL,
  `USCODIGO` varchar(50) DEFAULT NULL,
  `FUCODIGO` varchar(50) DEFAULT NULL,
  `PERIODO` varchar(50) DEFAULT NULL,
  `CACODIGO` varchar(50) DEFAULT NULL,
  `CODINTEG` varchar(50) DEFAULT NULL,
  `DCCODIGO` int(11) DEFAULT NULL,
  `NRECEB` int(11) DEFAULT NULL,
  `NDETCAIX` int(11) DEFAULT NULL,
  `APCODIGO` int(11) DEFAULT NULL,
  `VDCODIGO` int(11) DEFAULT NULL,
  `BACODIGO` varchar(50) DEFAULT NULL,
  `AGENCIA` varchar(50) DEFAULT NULL,
  `NUMCONTA` varchar(50) DEFAULT NULL,
  `NOSSONUMERO` int(11) DEFAULT NULL,
  `CCCODIGO` int(11) DEFAULT NULL,
  `NUMEROCOO` int(11) DEFAULT NULL,
  `DATAVENDA` date DEFAULT NULL,
  `ECFSERIE` varchar(50) DEFAULT NULL,
  `CNCCODIGO` int(11) DEFAULT NULL,
  `TIPOCONCILIACAO` varchar(50) DEFAULT NULL,
  `VALORORIGINAL` double DEFAULT NULL,
  `DESCONTOORIGINAL` double DEFAULT NULL,
  `DESCONTOORIGINA` double DEFAULT NULL,
  `TXEXPEDI` varchar(50) DEFAULT NULL,
  `STATUSCONC` varchar(50) DEFAULT NULL,
  `MVCDATA` date DEFAULT NULL,
  `MVCPERIODO` int(11) DEFAULT NULL,
  `MVCTIPO` varchar(50) DEFAULT NULL,
  `MVCFPCODIGO` int(11) DEFAULT NULL,
  `MVCSEQESPEC` int(11) DEFAULT NULL,
  `LCASEQUENCIA` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lancamen`
--

INSERT INTO `lancamen` (`LACODIGO`, `COCODIGO`, `CECODIGO`, `PLCODIGO`, `TIPO`, `DATALANC`, `DATAVENC`, `DATAEMBO`, `VALORANT`, `MOEDAANT`, `MULTA`, `JUROS`, `DESCONTO`, `VALOR`, `MOCODIGO`, `DATAQUIT`, `CLCODIGO`, `FOCODIGO`, `NUMCHEQ`, `NUMDUPL`, `MODELONF`, `SUBSERIENF`, `NUMERONF`, `SERIENF`, `VECODIGO`, `OBS`, `EMCODIGO`, `USCODIGO`, `FUCODIGO`, `PERIODO`, `CACODIGO`, `CODINTEG`, `DCCODIGO`, `NRECEB`, `NDETCAIX`, `APCODIGO`, `VDCODIGO`, `BACODIGO`, `AGENCIA`, `NUMCONTA`, `NOSSONUMERO`, `CCCODIGO`, `NUMEROCOO`, `DATAVENDA`, `ECFSERIE`, `CNCCODIGO`, `TIPOCONCILIACAO`, `VALORORIGINAL`, `DESCONTOORIGINAL`, `DESCONTOORIGINA`, `TXEXPEDI`, `STATUSCONC`, `MVCDATA`, `MVCPERIODO`, `MVCTIPO`, `MVCFPCODIGO`, `MVCSEQESPEC`, `LCASEQUENCIA`) VALUES
(1, '', '1', '12', 'C', '2018-05-22', '2018-05-22', NULL, 0, '', 0, 0, 0, 2.99, '', '2018-05-22', 0, 0, '', '000001-0/0', '', '', 0, '', 0, 'Venda feita pelo X2', 0, '', '1', '0', 'C1', '', NULL, 0, 0, 0, 1, '', '', '', 0, 0, 0, '2018-05-22', '', 0, '', 0, 0, NULL, '', '', '2018-05-22', 0, '', 0, 0, 0),
(2, '', '1', '12', 'C', '2018-05-22', '2018-05-22', NULL, 0, '', 0, 0, 0, 2.99, '', '2018-05-22', 0, 0, '', '000002-0/0', '', '', 0, '', 0, 'Venda feita pelo X2', 0, '', '1', '0', 'C1', '', NULL, 0, 0, 0, 2, '', '', '', 0, 0, 0, '2018-05-22', '', 0, '', 0, 0, NULL, '', '', '2018-05-22', 0, '', 0, 0, 0),
(3, '', '1', '12', 'C', '2018-05-22', '2018-05-22', NULL, 0, '', 0, 0, 0, 2.99, '', '2018-05-22', 0, 0, '', '000003-0/0', '', '', 0, '', 0, 'Venda feita pelo X2', 0, '', '1', '0', 'C1', '', NULL, 0, 0, 0, 3, '', '', '', 0, 0, 0, '2018-05-22', '', 0, '', 0, 0, NULL, '', '', '2018-05-22', 0, '', 0, 0, 0),
(4, '', '1', '12', 'C', '2018-05-22', '2018-05-22', NULL, 0, '', 0, 0, 0, 2.99, '', '2018-05-22', 0, 0, '', '000004-0/0', '', '', 0, '', 0, 'Venda feita pelo X2', 0, '', '1', '0', 'C1', '', NULL, 0, 0, 0, 4, '', '', '', 0, 0, 0, '2018-05-22', '', 0, '', 0, 0, NULL, '', '', '2018-05-22', 0, '', 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `madescli`
--

DROP TABLE IF EXISTS `madescli`;
CREATE TABLE IF NOT EXISTS `madescli` (
  `MFCODIGO` varchar(10) DEFAULT NULL,
  `CLCODIGO` int(11) DEFAULT NULL,
  `PERCDESC` double DEFAULT NULL,
  `DATAALTE` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `materpdv`
--

DROP TABLE IF EXISTS `materpdv`;
CREATE TABLE IF NOT EXISTS `materpdv` (
  `MFCODIGO` varchar(10) DEFAULT NULL,
  `NOME` varchar(50) DEFAULT NULL,
  `UNCODIGO` varchar(10) DEFAULT NULL,
  `CODORIGE` varchar(50) DEFAULT NULL,
  `CODTRIB` varchar(50) DEFAULT NULL,
  `CALCGORJ` varchar(50) DEFAULT NULL,
  `CODTRIBE` varchar(50) DEFAULT NULL,
  `PESAVEL` varchar(50) DEFAULT NULL,
  `LIBVENDA` varchar(50) DEFAULT NULL,
  `ALIQIPI` double DEFAULT NULL,
  `CODEXTRA` varchar(50) DEFAULT NULL,
  `REFERENCI` varchar(50) DEFAULT NULL,
  `GRADE` varchar(50) DEFAULT NULL,
  `COR` varchar(50) DEFAULT NULL,
  `TAMANHO` varchar(50) DEFAULT NULL,
  `CODINTERN` varchar(50) DEFAULT NULL,
  `TIPOTRIBU` varchar(50) DEFAULT NULL,
  `QTDESTOQ` double DEFAULT NULL,
  `PATHFOTO` varchar(50) DEFAULT NULL,
  `AGCODIGO` varchar(50) DEFAULT NULL,
  `CATSMART` int(11) DEFAULT NULL,
  `CODSMART` int(11) DEFAULT NULL,
  `SEQUENCIA` int(11) DEFAULT NULL,
  `COMPVDA` double DEFAULT NULL,
  `PRCCUMED` double DEFAULT NULL,
  `PRCCUCON` double DEFAULT NULL,
  `PCCUMECO` double DEFAULT NULL,
  `PRECOFAB` double DEFAULT NULL,
  `PRECOCUS` double DEFAULT NULL,
  `QTDNAEMB` double DEFAULT NULL,
  `DATAALTE` date DEFAULT NULL,
  `DTALTPRC` date DEFAULT NULL,
  `DTMOVEST` date DEFAULT NULL,
  `FOCODIGO` int(11) DEFAULT NULL,
  `UNIDENTR` varchar(50) DEFAULT NULL,
  `BASREDEN` double DEFAULT NULL,
  `BASREDCR` double DEFAULT NULL,
  `ALCODIGO` int(11) DEFAULT NULL,
  `ALCODENT` int(11) DEFAULT NULL,
  `PEDECOMPL` varchar(50) DEFAULT NULL,
  `COMPOSTO` varchar(50) DEFAULT NULL,
  `OBS01` varchar(50) DEFAULT NULL,
  `OBS02` varchar(50) DEFAULT NULL,
  `OBS03` varchar(50) DEFAULT NULL,
  `MARGEM` double DEFAULT NULL,
  `MAXDESCON` double DEFAULT NULL,
  `QTDEMIN` double DEFAULT NULL,
  `CONFEREN` varchar(50) DEFAULT NULL,
  `SITUACAO` varchar(50) DEFAULT NULL,
  `MOCODIGO` varchar(50) DEFAULT NULL,
  `PRCMOEDA` double DEFAULT NULL,
  `COTMOEDA` double DEFAULT NULL,
  `NBCODIGO` varchar(50) DEFAULT NULL,
  `MEDCONTR` varchar(50) DEFAULT NULL,
  `REGMINSA` varchar(50) DEFAULT NULL,
  `BALANCA` varchar(50) DEFAULT NULL,
  `QTDECONSIG` double DEFAULT NULL,
  `MFCODIDE` varchar(50) DEFAULT NULL,
  `CLASFISC` varchar(50) DEFAULT NULL,
  `SIGLA` varchar(50) DEFAULT NULL,
  `VACINA` varchar(50) DEFAULT NULL,
  `CONTNSERIE` varchar(50) DEFAULT NULL,
  `COMPLCOZI` varchar(50) DEFAULT NULL,
  `PRECOLOCA` double DEFAULT NULL,
  `PESO` double DEFAULT NULL,
  `COFINS` varchar(50) DEFAULT NULL,
  `PIS` varchar(50) DEFAULT NULL,
  `QTDEDISPLOC` double DEFAULT NULL,
  `DIASVALID` int(11) DEFAULT NULL,
  `PRCPONDE` double DEFAULT NULL,
  `TIPOFAB` varchar(50) DEFAULT NULL,
  `IAT` varchar(50) DEFAULT NULL,
  `IPICSTENT` varchar(50) DEFAULT NULL,
  `IPICSTSAIDA` varchar(50) DEFAULT NULL,
  `CODSEFMG` varchar(50) DEFAULT NULL,
  `PERMDESC` varchar(50) DEFAULT NULL,
  `ATIVDESC` varchar(50) DEFAULT NULL,
  `SERVMUN` varchar(50) DEFAULT NULL,
  `TIPOITEM` int(11) DEFAULT NULL,
  `CODCONTRV` varchar(50) DEFAULT NULL,
  `CODCONTCC` varchar(50) DEFAULT NULL,
  `CODCONTEST` varchar(50) DEFAULT NULL,
  `CODCONTDV` varchar(50) DEFAULT NULL,
  `DEC5161907` varchar(50) DEFAULT NULL,
  `UNCODENT` varchar(50) DEFAULT NULL,
  `ALIQCSLL` double DEFAULT NULL,
  `ALIQINSS` double DEFAULT NULL,
  `CODIGOANP` varchar(50) DEFAULT NULL,
  `AUTCODIF` varchar(50) DEFAULT NULL,
  `ALIQCIDE` double DEFAULT NULL,
  `CTRMEDICA` varchar(50) DEFAULT NULL,
  `PAFHASHVER` varchar(50) DEFAULT NULL,
  `PAFHASHEST` varchar(50) DEFAULT NULL,
  `PAFHASHSER` varchar(50) DEFAULT NULL,
  `PAFHASHTRI` varchar(50) DEFAULT NULL,
  `ECFSERIERZ` varchar(50) DEFAULT NULL,
  `ESTOQREDUZ` double DEFAULT NULL,
  `QTDEMBVDA` double DEFAULT NULL,
  `EX_IPI` varchar(50) DEFAULT NULL,
  `COD_LST` varchar(50) DEFAULT NULL,
  `PREVDESC` double DEFAULT NULL,
  `ATIVDPRE` varchar(50) DEFAULT NULL,
  `CFOENTRA` int(11) DEFAULT NULL,
  `CFOSAIDA` int(11) DEFAULT NULL,
  `COMBUSTIVEL` varchar(50) DEFAULT NULL,
  `LOCALIZACAO` varchar(50) DEFAULT NULL,
  `CHASSI` varchar(50) DEFAULT NULL,
  `PERCOMI` double DEFAULT NULL,
  `PERCOMIPRZ` double DEFAULT NULL,
  `BCAUNTICMS` varchar(50) DEFAULT NULL,
  `NAT_REC` varchar(50) DEFAULT NULL,
  `PIS_JURIDICA` varchar(50) DEFAULT NULL,
  `COFINS_JURIDICA` varchar(50) DEFAULT NULL,
  `CECODIGO` varchar(50) DEFAULT NULL,
  `LIMITESEC` varchar(50) DEFAULT NULL,
  `PRECOVEN` double DEFAULT NULL,
  `ALIQICMS` double DEFAULT NULL,
  `ALQICMSE` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `materpdv`
--

INSERT INTO `materpdv` (`MFCODIGO`, `NOME`, `UNCODIGO`, `CODORIGE`, `CODTRIB`, `CALCGORJ`, `CODTRIBE`, `PESAVEL`, `LIBVENDA`, `ALIQIPI`, `CODEXTRA`, `REFERENCI`, `GRADE`, `COR`, `TAMANHO`, `CODINTERN`, `TIPOTRIBU`, `QTDESTOQ`, `PATHFOTO`, `AGCODIGO`, `CATSMART`, `CODSMART`, `SEQUENCIA`, `COMPVDA`, `PRCCUMED`, `PRCCUCON`, `PCCUMECO`, `PRECOFAB`, `PRECOCUS`, `QTDNAEMB`, `DATAALTE`, `DTALTPRC`, `DTMOVEST`, `FOCODIGO`, `UNIDENTR`, `BASREDEN`, `BASREDCR`, `ALCODIGO`, `ALCODENT`, `PEDECOMPL`, `COMPOSTO`, `OBS01`, `OBS02`, `OBS03`, `MARGEM`, `MAXDESCON`, `QTDEMIN`, `CONFEREN`, `SITUACAO`, `MOCODIGO`, `PRCMOEDA`, `COTMOEDA`, `NBCODIGO`, `MEDCONTR`, `REGMINSA`, `BALANCA`, `QTDECONSIG`, `MFCODIDE`, `CLASFISC`, `SIGLA`, `VACINA`, `CONTNSERIE`, `COMPLCOZI`, `PRECOLOCA`, `PESO`, `COFINS`, `PIS`, `QTDEDISPLOC`, `DIASVALID`, `PRCPONDE`, `TIPOFAB`, `IAT`, `IPICSTENT`, `IPICSTSAIDA`, `CODSEFMG`, `PERMDESC`, `ATIVDESC`, `SERVMUN`, `TIPOITEM`, `CODCONTRV`, `CODCONTCC`, `CODCONTEST`, `CODCONTDV`, `DEC5161907`, `UNCODENT`, `ALIQCSLL`, `ALIQINSS`, `CODIGOANP`, `AUTCODIF`, `ALIQCIDE`, `CTRMEDICA`, `PAFHASHVER`, `PAFHASHEST`, `PAFHASHSER`, `PAFHASHTRI`, `ECFSERIERZ`, `ESTOQREDUZ`, `QTDEMBVDA`, `EX_IPI`, `COD_LST`, `PREVDESC`, `ATIVDPRE`, `CFOENTRA`, `CFOSAIDA`, `COMBUSTIVEL`, `LOCALIZACAO`, `CHASSI`, `PERCOMI`, `PERCOMIPRZ`, `BCAUNTICMS`, `NAT_REC`, `PIS_JURIDICA`, `COFINS_JURIDICA`, `CECODIGO`, `LIMITESEC`, `PRECOVEN`, `ALIQICMS`, `ALQICMSE`) VALUES
('10', 'PRODUTO 1', '1', '10', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 11, 10, 6, 7, 4, 4, NULL, '2018-05-29', '2018-05-17', '2018-05-16', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'A', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2.99, NULL, NULL),
('11', 'PRODUTO 1', '1', '110', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 11, 10, 6, 7, 4, 4, NULL, '2018-05-29', '2018-05-17', '2018-05-16', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'A', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2.99, NULL, NULL),
('30', 'PRODUTO 30', '1', '30', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 11, 10, 6, 7, 4, 4, NULL, '2018-05-29', '2018-05-17', '2018-05-16', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'A', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2.99, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `mvcaipdv`
--

DROP TABLE IF EXISTS `mvcaipdv`;
CREATE TABLE IF NOT EXISTS `mvcaipdv` (
  `CACODIGO` varchar(100) DEFAULT NULL,
  `DATA` date DEFAULT NULL,
  `PERIODO` int(11) DEFAULT NULL,
  `TIPO` varchar(100) DEFAULT NULL,
  `VDCODIGO` int(11) DEFAULT NULL,
  `FPCODIGO` int(11) DEFAULT NULL,
  `SEQESPEC` int(11) DEFAULT NULL,
  `ESPPGECF` varchar(100) DEFAULT NULL,
  `LACODIGO` int(11) DEFAULT NULL,
  `FUCODIGO` int(11) DEFAULT NULL,
  `PLCODIGO` varchar(100) DEFAULT NULL,
  `VALOR` double DEFAULT NULL,
  `FORMPGTO` varchar(100) DEFAULT NULL,
  `NUMPARCE` int(11) DEFAULT NULL,
  `DATACOMP` date DEFAULT NULL,
  `HORACOMP` varchar(100) DEFAULT NULL,
  `SETORUSO` varchar(100) DEFAULT NULL,
  `DTCODIGO` int(11) DEFAULT NULL,
  `AUTORITRANSACAO` varchar(100) DEFAULT NULL,
  `BANDEIRA` varchar(100) DEFAULT NULL,
  `TIPOPAGAMENTO` varchar(100) DEFAULT NULL,
  `TIPOFINANCIAMEN` varchar(100) DEFAULT NULL,
  `TEFSERVIDOR` varchar(100) DEFAULT NULL,
  `TEFVLRTREFET` double DEFAULT NULL,
  `TEFVLRTREFEA` double DEFAULT NULL,
  `TEFIDENTIFIC` varchar(100) DEFAULT NULL,
  `TEFDADOSFINA` varchar(100) DEFAULT NULL,
  `TEFREDEAUTOR` varchar(100) DEFAULT NULL,
  `TEFTIPTRREDE` varchar(100) DEFAULT NULL,
  `TEFNUTRANNSU` varchar(100) DEFAULT NULL,
  `TEFCODAUTTRA` varchar(100) DEFAULT NULL,
  `TEFTXVLRTRAN` varchar(100) DEFAULT NULL,
  `TEFDATATRANS` varchar(100) DEFAULT NULL,
  `TEFHORATRANS` varchar(100) DEFAULT NULL,
  `TEFCODMODPGT` varchar(100) DEFAULT NULL,
  `TEFTXMODAPGT` varchar(100) DEFAULT NULL,
  `TEFTXMOPGCUP` varchar(100) DEFAULT NULL,
  `TEFNSUSITEF` varchar(100) DEFAULT NULL,
  `TEFBIMCARTAO` varchar(100) DEFAULT NULL,
  `TEFNUPARCELA` varchar(100) DEFAULT NULL,
  `TEFDTPREDATA` varchar(100) DEFAULT NULL,
  `TEFNOMEOPCEL` varchar(100) DEFAULT NULL,
  `TEFVLRRECARG` varchar(100) DEFAULT NULL,
  `TEFDDDNUMCEL` varchar(100) DEFAULT NULL,
  `TEFDIGIVERIF` varchar(100) DEFAULT NULL,
  `TEFCEPLTEOPE` varchar(100) DEFAULT NULL,
  `TEFNSUSTPRCA` varchar(100) DEFAULT NULL,
  `TEFNSUHATPRC` varchar(100) DEFAULT NULL,
  `TEFCOFIATRCE` varchar(100) DEFAULT NULL,
  `TEFNUMPARCEL` varchar(100) DEFAULT NULL,
  `TEFNUMTERLOG` varchar(100) DEFAULT NULL,
  `TEFCODAFILIA` varchar(100) DEFAULT NULL,
  `FLAGTRANS` varchar(100) DEFAULT NULL,
  `FLAGTSERV` varchar(100) DEFAULT NULL,
  `ECFSEQUE` varchar(100) DEFAULT NULL,
  `ECFSERIE` varchar(100) DEFAULT NULL,
  `ECFMARCA` varchar(100) DEFAULT NULL,
  `ECFMODELO` varchar(100) DEFAULT NULL,
  `ECFTIPO` varchar(100) DEFAULT NULL,
  `SWBVERSAO` varchar(100) DEFAULT NULL,
  `SWBDTHRGR` date DEFAULT NULL,
  `SWBMFADIC` varchar(100) DEFAULT NULL,
  `COO` int(11) DEFAULT NULL,
  `GNF` int(11) DEFAULT NULL,
  `CCF` int(11) DEFAULT NULL,
  `GRG` int(11) DEFAULT NULL,
  `CER` int(11) DEFAULT NULL,
  `TPVENDCART` varchar(100) DEFAULT NULL,
  `CADEVOLUC` varchar(100) DEFAULT NULL,
  `DVCODIGO` int(11) DEFAULT NULL,
  `ORIGEM` varchar(100) DEFAULT NULL,
  `PAFHASHVER` varchar(100) DEFAULT NULL,
  `PAFHASHDET` varchar(100) DEFAULT NULL,
  `DATADAMOV` date DEFAULT NULL,
  `MODELONF` varchar(100) DEFAULT NULL,
  `SERIENF` varchar(100) DEFAULT NULL,
  `SUBSERIENF` varchar(100) DEFAULT NULL,
  `NUMERONF` int(11) DEFAULT NULL,
  `FLAGFINAN` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mvcaipdv`
--

INSERT INTO `mvcaipdv` (`CACODIGO`, `DATA`, `PERIODO`, `TIPO`, `VDCODIGO`, `FPCODIGO`, `SEQESPEC`, `ESPPGECF`, `LACODIGO`, `FUCODIGO`, `PLCODIGO`, `VALOR`, `FORMPGTO`, `NUMPARCE`, `DATACOMP`, `HORACOMP`, `SETORUSO`, `DTCODIGO`, `AUTORITRANSACAO`, `BANDEIRA`, `TIPOPAGAMENTO`, `TIPOFINANCIAMEN`, `TEFSERVIDOR`, `TEFVLRTREFET`, `TEFVLRTREFEA`, `TEFIDENTIFIC`, `TEFDADOSFINA`, `TEFREDEAUTOR`, `TEFTIPTRREDE`, `TEFNUTRANNSU`, `TEFCODAUTTRA`, `TEFTXVLRTRAN`, `TEFDATATRANS`, `TEFHORATRANS`, `TEFCODMODPGT`, `TEFTXMODAPGT`, `TEFTXMOPGCUP`, `TEFNSUSITEF`, `TEFBIMCARTAO`, `TEFNUPARCELA`, `TEFDTPREDATA`, `TEFNOMEOPCEL`, `TEFVLRRECARG`, `TEFDDDNUMCEL`, `TEFDIGIVERIF`, `TEFCEPLTEOPE`, `TEFNSUSTPRCA`, `TEFNSUHATPRC`, `TEFCOFIATRCE`, `TEFNUMPARCEL`, `TEFNUMTERLOG`, `TEFCODAFILIA`, `FLAGTRANS`, `FLAGTSERV`, `ECFSEQUE`, `ECFSERIE`, `ECFMARCA`, `ECFMODELO`, `ECFTIPO`, `SWBVERSAO`, `SWBDTHRGR`, `SWBMFADIC`, `COO`, `GNF`, `CCF`, `GRG`, `CER`, `TPVENDCART`, `CADEVOLUC`, `DVCODIGO`, `ORIGEM`, `PAFHASHVER`, `PAFHASHDET`, `DATADAMOV`, `MODELONF`, `SERIENF`, `SUBSERIENF`, `NUMERONF`, `FLAGFINAN`) VALUES
('C1', '2018-05-22', 0, 'V', 1, 1, 1, 'Dinheiro', 0, 1, '', 2.99, 'Q', 0, '2018-05-22', '18:52\n', 'LOJA', 0, '', '', 'Dinheiro', '', '', 0, 0, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'X2', '', '', '', '2018-05-22', '', 0, 0, 0, 0, 0, '', '', 0, 'MOVIM', '', '', '2018-05-22', '', '', '', 0, ''),
('C1', '2018-05-22', 0, 'V', 2, 1, 1, 'Dinheiro', 0, 1, '', 2.99, 'Q', 0, '2018-05-22', '19:10\n', 'LOJA', 0, '', '', 'Dinheiro', '', '', 0, 0, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'X2', '', '', '', '2018-05-22', '', 0, 0, 0, 0, 0, '', '', 0, 'MOVIM', '', '', '2018-05-22', '', '', '', 0, ''),
('C1', '2018-05-22', 0, 'V', 3, 1, 1, 'Dinheiro', 0, 1, '', 2.99, 'Q', 0, '2018-05-22', '19:51\n', 'LOJA', 0, '', '', 'Dinheiro', '', '', 0, 0, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'X2', '', '', '', '2018-05-22', '', 0, 0, 0, 0, 0, '', '', 0, 'MOVIM', '', '', '2018-05-22', '', '', '', 0, ''),
('C1', '2018-05-22', 0, 'V', 4, 1, 1, 'Dinheiro', 0, 1, '', 2.99, 'Q', 0, '2018-05-22', '20:13\n', 'LOJA', 0, '', '', 'Dinheiro', '', '', 0, 0, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'X2', '', '', '', '2018-05-22', '', 0, 0, 0, 0, 0, '', '', 0, 'MOVIM', '', '', '2018-05-22', '', '', '', 0, '');

-- --------------------------------------------------------

--
-- Table structure for table `orcament`
--

DROP TABLE IF EXISTS `orcament`;
CREATE TABLE IF NOT EXISTS `orcament` (
  `ORCODIGO` varchar(50) DEFAULT NULL,
  `DATA` date DEFAULT NULL,
  `FUCODIGO` int(11) DEFAULT NULL,
  `CLCODIGO` int(11) DEFAULT NULL,
  `TIPO` varchar(50) DEFAULT NULL,
  `NOME` varchar(50) DEFAULT NULL,
  `CNPJ` varchar(50) DEFAULT NULL,
  `CPF` varchar(50) DEFAULT NULL,
  `ENDERECO` varchar(50) DEFAULT NULL,
  `BAIRRO` varchar(50) DEFAULT NULL,
  `CICODIGO` int(11) DEFAULT NULL,
  `CEP` varchar(50) DEFAULT NULL,
  `UF` varchar(50) DEFAULT NULL,
  `TELEFONE` varchar(50) DEFAULT NULL,
  `CUIDADOS` varchar(50) DEFAULT NULL,
  `FPCODIGO` varchar(50) DEFAULT NULL,
  `TIPOPRECO` varchar(50) DEFAULT NULL,
  `DESCONTO` double DEFAULT NULL,
  `ACRESCIMO` double DEFAULT NULL,
  `VALORTOT` double DEFAULT NULL,
  `DATAVALID` date DEFAULT NULL,
  `DTPARAENT` date DEFAULT NULL,
  `TOTALIPI` double DEFAULT NULL,
  `NUMPEDCLI` varchar(50) DEFAULT NULL,
  `SITUACAO` varchar(50) DEFAULT NULL,
  `QTDITENS` int(11) DEFAULT NULL,
  `OPCODIGO` int(11) DEFAULT NULL,
  `OBSERVA1` varchar(50) DEFAULT NULL,
  `OBSERVA2` varchar(50) DEFAULT NULL,
  `OBSERVA3` varchar(50) DEFAULT NULL,
  `OBSERVA4` varchar(50) DEFAULT NULL,
  `OBSERVA5` varchar(50) DEFAULT NULL,
  `TOTFRETE` double DEFAULT NULL,
  `TOTICMS` double DEFAULT NULL,
  `PRAZO` varchar(50) DEFAULT NULL,
  `CACODIGO` varchar(50) DEFAULT NULL,
  `VDCODIGO` int(11) DEFAULT NULL,
  `NUMEROCOO` int(11) DEFAULT NULL,
  `NUMEROCCF` int(11) DEFAULT NULL,
  `MDCODIGO` int(11) DEFAULT NULL,
  `MCCODIGO` int(11) DEFAULT NULL,
  `ANO` varchar(50) DEFAULT NULL,
  `DATAAPRO` date DEFAULT NULL,
  `FUAPROVA` int(11) DEFAULT NULL,
  `DATACONF` date DEFAULT NULL,
  `FUCONFER` int(11) DEFAULT NULL,
  `SERIE` varchar(50) DEFAULT NULL,
  `FLAGTRANS` varchar(50) DEFAULT NULL,
  `NUMPLACA` varchar(50) DEFAULT NULL,
  `NUMRENAVAM` varchar(50) DEFAULT NULL,
  `ORCODPAI` int(11) DEFAULT NULL,
  `OBSCLI` varchar(50) DEFAULT NULL,
  `DAV` int(11) DEFAULT NULL,
  `MODELONF` varchar(50) DEFAULT NULL,
  `SERIENF` varchar(50) DEFAULT NULL,
  `SUBSERIENF` varchar(50) DEFAULT NULL,
  `NUMERONF` int(11) DEFAULT NULL,
  `CVCODIGO` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orcament`
--

INSERT INTO `orcament` (`ORCODIGO`, `DATA`, `FUCODIGO`, `CLCODIGO`, `TIPO`, `NOME`, `CNPJ`, `CPF`, `ENDERECO`, `BAIRRO`, `CICODIGO`, `CEP`, `UF`, `TELEFONE`, `CUIDADOS`, `FPCODIGO`, `TIPOPRECO`, `DESCONTO`, `ACRESCIMO`, `VALORTOT`, `DATAVALID`, `DTPARAENT`, `TOTALIPI`, `NUMPEDCLI`, `SITUACAO`, `QTDITENS`, `OPCODIGO`, `OBSERVA1`, `OBSERVA2`, `OBSERVA3`, `OBSERVA4`, `OBSERVA5`, `TOTFRETE`, `TOTICMS`, `PRAZO`, `CACODIGO`, `VDCODIGO`, `NUMEROCOO`, `NUMEROCCF`, `MDCODIGO`, `MCCODIGO`, `ANO`, `DATAAPRO`, `FUAPROVA`, `DATACONF`, `FUCONFER`, `SERIE`, `FLAGTRANS`, `NUMPLACA`, `NUMRENAVAM`, `ORCODPAI`, `OBSCLI`, `DAV`, `MODELONF`, `SERIENF`, `SUBSERIENF`, `NUMERONF`, `CVCODIGO`) VALUES
('1', '2018-05-22', 1, 0, 'F', '', '', '', '', '', 0, '', '', '', '', '1', 'V', 0, 0, 2.99, '2018-05-22', NULL, 0, '', 'E', 1, 0, '', '', '', '', '', 0, 0, '', 'C1', 0, 0, 0, 0, 0, '', NULL, 0, NULL, 0, '', '', '', '', 0, NULL, 0, '', '', '', 0, 0),
('2', '2018-05-22', 1, 0, 'F', '', '', '', '', '', 0, '', '', '', '', '1', 'V', 0, 0, 2.99, '2018-05-22', NULL, 0, '', 'E', 1, 0, '', '', '', '', '', 0, 0, '', 'C1', 0, 0, 0, 0, 0, '', NULL, 0, NULL, 0, '', '', '', '', 0, NULL, 0, '', '', '', 0, 0),
('3', '2018-05-22', 1, 54, 'J', 'CAMARA MUNICIPAL DE PEDRA DO INDAIA', '2147483647', '', '1 DE MARCO', 'CENTRO', 3692, '35565000', 'MG', '', '', '1', 'V', 0, 0, 2.99, '2018-05-22', NULL, 0, '', 'E', 1, 0, '', '', '', '', '', 0, 0, '', 'C1', 0, 0, 0, 0, 0, '', NULL, 0, NULL, 0, '', '', '', '', 0, NULL, 0, '', '', '', 0, 0),
('4', '2018-05-22', 1, 0, 'F', '', '', '', '', '', 0, '', '', '', '', '1', 'V', 0, 0, 2.99, '2018-05-22', NULL, 0, '', 'E', 1, 0, '', '', '', '', '', 0, 0, '', 'C1', 0, 0, 0, 0, 0, '', NULL, 0, NULL, 0, '', '', '', '', 0, NULL, 0, '', '', '', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `prevdpdv`
--

DROP TABLE IF EXISTS `prevdpdv`;
CREATE TABLE IF NOT EXISTS `prevdpdv` (
  `VDCODIGO` int(11) DEFAULT NULL,
  `CACODIGO` varchar(100) DEFAULT NULL,
  `SITUACAO` varchar(100) DEFAULT NULL,
  `STSPROC` varchar(100) DEFAULT NULL,
  `CODSOLICITFARMA` varchar(100) DEFAULT NULL,
  `NUMAUTORIZACAO` varchar(100) DEFAULT NULL,
  `MSGPROC` varchar(100) DEFAULT NULL,
  `VDACACOD` varchar(100) DEFAULT NULL,
  `VDAVDCOD` int(11) DEFAULT NULL,
  `CAFECHPRE` varchar(100) DEFAULT NULL,
  `NUMERONF` int(11) DEFAULT NULL,
  `SERIENF` varchar(100) DEFAULT NULL,
  `PRECANC` varchar(100) DEFAULT NULL,
  `DATAHORACUP` date DEFAULT NULL,
  `DATA` date DEFAULT NULL,
  `VENDEDOR` int(11) DEFAULT NULL,
  `CLCODIGO` int(11) DEFAULT NULL,
  `NOMECLIE` varchar(100) DEFAULT NULL,
  `CGCCLIE` varchar(100) DEFAULT NULL,
  `CPFCLIE` varchar(100) DEFAULT NULL,
  `LIMCREBAI` double DEFAULT NULL,
  `LIMCRESEC` double DEFAULT NULL,
  `CODINTERN` varchar(100) DEFAULT NULL,
  `DESCONTO` double DEFAULT NULL,
  `ACRESCIMO` double DEFAULT NULL,
  `VALVENDA` double DEFAULT NULL,
  `EQUIPAME` int(11) DEFAULT NULL,
  `MSCODIGO` varchar(100) DEFAULT NULL,
  `MECODIGO` int(11) DEFAULT NULL,
  `DATAAMESA` date DEFAULT NULL,
  `CONFECFSER` varchar(100) DEFAULT NULL,
  `CONFEECF` varchar(100) DEFAULT NULL,
  `CONFECOO` int(11) DEFAULT NULL,
  `CONFECER` int(11) DEFAULT NULL,
  `FUCODIGO` int(11) DEFAULT NULL,
  `PERIODO` int(11) DEFAULT NULL,
  `HORARIO` varchar(100) DEFAULT NULL,
  `ECFSEQUE` varchar(100) DEFAULT NULL,
  `ECFSERIE` varchar(100) DEFAULT NULL,
  `ECFMARCA` varchar(100) DEFAULT NULL,
  `ECFMODELO` varchar(100) DEFAULT NULL,
  `ECFTIPO` varchar(100) DEFAULT NULL,
  `SWBVERSAO` varchar(100) DEFAULT NULL,
  `SWBDTHRGR` date DEFAULT NULL,
  `SWBMFADIC` varchar(100) DEFAULT NULL,
  `NUMCUPOM` int(11) DEFAULT NULL,
  `QTDPESSOA` int(11) DEFAULT NULL,
  `QTDCUPENT` int(11) DEFAULT NULL,
  `HORAINIC` varchar(100) DEFAULT NULL,
  `HORAPAGT` varchar(100) DEFAULT NULL,
  `DAV` int(11) DEFAULT NULL,
  `NUMORCAM` varchar(100) DEFAULT NULL,
  `NOME` varchar(100) DEFAULT NULL,
  `ENDERECO` varchar(100) DEFAULT NULL,
  `TELEFONE` varchar(100) DEFAULT NULL,
  `DOCUMENTO` varchar(100) DEFAULT NULL,
  `NUMEROCOO` int(11) DEFAULT NULL,
  `OBS1` varchar(100) DEFAULT NULL,
  `OBS2` varchar(100) DEFAULT NULL,
  `OBS3` varchar(100) DEFAULT NULL,
  `OBS4` varchar(100) DEFAULT NULL,
  `OBS5` varchar(100) DEFAULT NULL,
  `OBS6` varchar(100) DEFAULT NULL,
  `OBS7` varchar(100) DEFAULT NULL,
  `OBS8` varchar(100) DEFAULT NULL,
  `KM` int(11) DEFAULT NULL,
  `PLACA` varchar(100) DEFAULT NULL,
  `BAIXAESTO` varchar(100) DEFAULT NULL,
  `CLCODPAI` int(11) DEFAULT NULL,
  `FLAGTRANS` varchar(100) DEFAULT NULL,
  `FICODIGO` int(11) DEFAULT NULL,
  `SETORUSO` varchar(100) DEFAULT NULL,
  `FACODIGO` int(11) DEFAULT NULL,
  `CENTCUSTO` varchar(100) DEFAULT NULL,
  `PASEMBARQUE` varchar(100) DEFAULT NULL,
  `PASDESTINO` varchar(100) DEFAULT NULL,
  `PASLINHA` varchar(100) DEFAULT NULL,
  `PASAGENCIA` varchar(100) DEFAULT NULL,
  `PASDATA` varchar(100) DEFAULT NULL,
  `PASHORA` varchar(100) DEFAULT NULL,
  `PASPOLTRONA` varchar(100) DEFAULT NULL,
  `PASPLATAFORMA` varchar(100) DEFAULT NULL,
  `PASTIPOPASSAGEM` varchar(100) DEFAULT NULL,
  `PASRG` varchar(100) DEFAULT NULL,
  `PASNOME` varchar(100) DEFAULT NULL,
  `PASENDERECO` varchar(100) DEFAULT NULL,
  `PASUFDESTINO` varchar(100) DEFAULT NULL,
  `PASPERCURSO` int(11) DEFAULT NULL,
  `PASTPVENDA` int(11) DEFAULT NULL,
  `PASCODARD` int(11) DEFAULT NULL,
  `CODAUTOEXT` varchar(100) DEFAULT NULL,
  `ORIGEM` varchar(100) DEFAULT NULL,
  `MULTMESAS` varchar(100) DEFAULT NULL,
  `PAFINDCANC` varchar(100) DEFAULT NULL,
  `MODELODOC` varchar(100) DEFAULT NULL,
  `PAFHASHVER` varchar(100) DEFAULT NULL,
  `PAFHASHCAP` varchar(100) DEFAULT NULL,
  `VLRBCPIS` double DEFAULT NULL,
  `VALORPIS` double DEFAULT NULL,
  `VLRPISST` double DEFAULT NULL,
  `VLRBCCFS` double DEFAULT NULL,
  `VALORCFS` double DEFAULT NULL,
  `VLRCFSST` double DEFAULT NULL,
  `DATADAMOV` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prevdpdv`
--

INSERT INTO `prevdpdv` (`VDCODIGO`, `CACODIGO`, `SITUACAO`, `STSPROC`, `CODSOLICITFARMA`, `NUMAUTORIZACAO`, `MSGPROC`, `VDACACOD`, `VDAVDCOD`, `CAFECHPRE`, `NUMERONF`, `SERIENF`, `PRECANC`, `DATAHORACUP`, `DATA`, `VENDEDOR`, `CLCODIGO`, `NOMECLIE`, `CGCCLIE`, `CPFCLIE`, `LIMCREBAI`, `LIMCRESEC`, `CODINTERN`, `DESCONTO`, `ACRESCIMO`, `VALVENDA`, `EQUIPAME`, `MSCODIGO`, `MECODIGO`, `DATAAMESA`, `CONFECFSER`, `CONFEECF`, `CONFECOO`, `CONFECER`, `FUCODIGO`, `PERIODO`, `HORARIO`, `ECFSEQUE`, `ECFSERIE`, `ECFMARCA`, `ECFMODELO`, `ECFTIPO`, `SWBVERSAO`, `SWBDTHRGR`, `SWBMFADIC`, `NUMCUPOM`, `QTDPESSOA`, `QTDCUPENT`, `HORAINIC`, `HORAPAGT`, `DAV`, `NUMORCAM`, `NOME`, `ENDERECO`, `TELEFONE`, `DOCUMENTO`, `NUMEROCOO`, `OBS1`, `OBS2`, `OBS3`, `OBS4`, `OBS5`, `OBS6`, `OBS7`, `OBS8`, `KM`, `PLACA`, `BAIXAESTO`, `CLCODPAI`, `FLAGTRANS`, `FICODIGO`, `SETORUSO`, `FACODIGO`, `CENTCUSTO`, `PASEMBARQUE`, `PASDESTINO`, `PASLINHA`, `PASAGENCIA`, `PASDATA`, `PASHORA`, `PASPOLTRONA`, `PASPLATAFORMA`, `PASTIPOPASSAGEM`, `PASRG`, `PASNOME`, `PASENDERECO`, `PASUFDESTINO`, `PASPERCURSO`, `PASTPVENDA`, `PASCODARD`, `CODAUTOEXT`, `ORIGEM`, `MULTMESAS`, `PAFINDCANC`, `MODELODOC`, `PAFHASHVER`, `PAFHASHCAP`, `VLRBCPIS`, `VALORPIS`, `VLRPISST`, `VLRBCCFS`, `VALORCFS`, `VLRCFSST`, `DATADAMOV`) VALUES
(1, 'C1', '', '', '', '', '', '', 0, '', 0, '', '', '2018-05-22', '2018-05-22', 1, 0, '', '', '', 0, 0, '', 0, 0, 2.99, 1, '0', 0, '2018-05-22', '', '', 0, 0, 1, 1, '20:13\n', '  ', 'X2', '', '', '', '', NULL, '', 0, 1, 0, '20:13\n', '20:13\n', 0, '', '', '', '', '', 0, '', '', '', '', '', '', '', '', 0, '', 'S', 0, NULL, 0, 'LOJA', 0, '1', '', '', '', '', '', '', '', '', '', '', '', '', '', 0, 0, 0, '', 'MOVIM', 'N', 'N', '2D', '4.01', '', 0, 0, 0, 0, 0, 0, '2018-05-22');

-- --------------------------------------------------------

--
-- Table structure for table `tipofunc`
--

DROP TABLE IF EXISTS `tipofunc`;
CREATE TABLE IF NOT EXISTS `tipofunc` (
  `TFCODIGO` varchar(200) DEFAULT NULL,
  `NOME` varchar(200) DEFAULT NULL,
  `HCCODIGO` int(11) UNSIGNED ZEROFILL NOT NULL,
  `DATAALTE` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tipofunc`
--

INSERT INTO `tipofunc` (`TFCODIGO`, `NOME`, `HCCODIGO`, `DATAALTE`) VALUES
('1', 'Geral', 00000000011, '2018-05-15 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `unidades`
--

DROP TABLE IF EXISTS `unidades`;
CREATE TABLE IF NOT EXISTS `unidades` (
  `UNCODIGO` varchar(10) DEFAULT NULL,
  `NOME` varchar(50) DEFAULT NULL,
  `DATAALTE` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `unidades`
--

INSERT INTO `unidades` (`UNCODIGO`, `NOME`, `DATAALTE`) VALUES
('1', 'UNIDADE 1', '2018-05-01'),
('2', 'UNIDADE 2', '2018-05-23'),
('3', 'UNIDADE 3', '2018-05-01'),
('4', 'UNIDADE 4', '2018-05-23');

-- --------------------------------------------------------

--
-- Table structure for table `vendapdv`
--

DROP TABLE IF EXISTS `vendapdv`;
CREATE TABLE IF NOT EXISTS `vendapdv` (
  `CACODIGO` varchar(100) DEFAULT NULL,
  `VDCODIGO` int(11) DEFAULT NULL,
  `DATACANC` date DEFAULT NULL,
  `CODAUTOR` int(11) DEFAULT NULL,
  `DATAHORACUP` date DEFAULT NULL,
  `DATA` date DEFAULT NULL,
  `VENDEDOR` int(11) DEFAULT NULL,
  `CLCODIGO` int(11) DEFAULT NULL,
  `NOMECLIE` varchar(100) DEFAULT NULL,
  `CGCCLIE` varchar(100) DEFAULT NULL,
  `CPFCLIE` varchar(100) DEFAULT NULL,
  `LIMCREBAI` double DEFAULT NULL,
  `LIMCRESEC` double DEFAULT NULL,
  `CODINTERN` varchar(100) DEFAULT NULL,
  `DESCONTO` double DEFAULT NULL,
  `ACRESCIMO` double DEFAULT NULL,
  `VALVENDA` double DEFAULT NULL,
  `EQUIPAME` int(11) DEFAULT NULL,
  `MSCODIGO` varchar(100) DEFAULT NULL,
  `MECODIGO` int(11) DEFAULT NULL,
  `DATAAMESA` date DEFAULT NULL,
  `CONFECFSER` varchar(100) DEFAULT NULL,
  `CONFEECF` varchar(100) DEFAULT NULL,
  `CONFECOO` int(11) DEFAULT NULL,
  `CONFECER` int(11) DEFAULT NULL,
  `FUCODIGO` int(11) DEFAULT NULL,
  `PERIODO` int(11) DEFAULT NULL,
  `HORARIO` varchar(100) DEFAULT NULL,
  `ECFSEQUE` varchar(100) DEFAULT NULL,
  `ECFSERIE` varchar(100) DEFAULT NULL,
  `ECFMARCA` varchar(100) DEFAULT NULL,
  `ECFMODELO` varchar(100) DEFAULT NULL,
  `ECFTIPO` varchar(100) DEFAULT NULL,
  `SWBVERSAO` varchar(100) DEFAULT NULL,
  `SWBDTHRGR` date DEFAULT NULL,
  `SWBMFADIC` varchar(100) DEFAULT NULL,
  `NUMCUPOM` int(11) DEFAULT NULL,
  `QTDPESSOA` int(11) DEFAULT NULL,
  `QTDCUPENT` int(11) DEFAULT NULL,
  `HORAINIC` varchar(100) DEFAULT NULL,
  `HORAPAGT` varchar(100) DEFAULT NULL,
  `DAV` int(11) DEFAULT NULL,
  `NUMORCAM` varchar(100) DEFAULT NULL,
  `NOME` varchar(100) DEFAULT NULL,
  `ENDERECO` varchar(100) DEFAULT NULL,
  `TELEFONE` varchar(100) DEFAULT NULL,
  `DOCUMENTO` varchar(100) DEFAULT NULL,
  `NUMEROCOO` int(11) DEFAULT NULL,
  `OBS1` varchar(100) DEFAULT NULL,
  `OBS2` varchar(100) DEFAULT NULL,
  `OBS3` varchar(100) DEFAULT NULL,
  `OBS4` varchar(100) DEFAULT NULL,
  `OBS5` varchar(100) DEFAULT NULL,
  `OBS6` varchar(100) DEFAULT NULL,
  `OBS7` varchar(100) DEFAULT NULL,
  `OBS8` varchar(100) DEFAULT NULL,
  `KM` int(11) DEFAULT NULL,
  `PLACA` varchar(100) DEFAULT NULL,
  `BAIXAESTO` varchar(100) DEFAULT NULL,
  `CLCODPAI` int(11) DEFAULT NULL,
  `FLAGTRANS` varchar(100) DEFAULT NULL,
  `FLAGTSERV` varchar(100) DEFAULT NULL,
  `FLAGFINAN` varchar(1) DEFAULT NULL,
  `FICODIGO` int(11) DEFAULT NULL,
  `SETORUSO` varchar(100) DEFAULT NULL,
  `FACODIGO` int(11) DEFAULT NULL,
  `CENTCUSTO` varchar(100) DEFAULT NULL,
  `PASEMBARQUE` varchar(100) DEFAULT NULL,
  `PASDESTINO` varchar(100) DEFAULT NULL,
  `PASLINHA` varchar(100) DEFAULT NULL,
  `PASAGENCIA` varchar(100) DEFAULT NULL,
  `PASDATA` varchar(100) DEFAULT NULL,
  `PASHORA` varchar(100) DEFAULT NULL,
  `PASPOLTRONA` varchar(100) DEFAULT NULL,
  `PASPLATAFORMA` varchar(100) DEFAULT NULL,
  `PASTIPOPASSAGEM` varchar(100) DEFAULT NULL,
  `PASRG` varchar(100) DEFAULT NULL,
  `PASNOME` varchar(100) DEFAULT NULL,
  `PASENDERECO` varchar(100) DEFAULT NULL,
  `PASUFDESTINO` varchar(100) DEFAULT NULL,
  `PASPERCURSO` int(11) DEFAULT NULL,
  `PASTPVENDA` int(11) DEFAULT NULL,
  `PASCODARD` int(11) DEFAULT NULL,
  `CODAUTOEXT` varchar(100) DEFAULT NULL,
  `ORIGEM` varchar(100) DEFAULT NULL,
  `MULTMESAS` varchar(100) DEFAULT NULL,
  `PAFINDCANC` varchar(100) DEFAULT NULL,
  `MODELODOC` varchar(100) DEFAULT NULL,
  `PAFHASHVER` varchar(100) DEFAULT NULL,
  `PAFHASHCAP` varchar(100) DEFAULT NULL,
  `VLRBCPIS` double DEFAULT NULL,
  `VALORPIS` double DEFAULT NULL,
  `VLRPISST` double DEFAULT NULL,
  `VLRBCCFS` double DEFAULT NULL,
  `VALORCFS` double DEFAULT NULL,
  `VLRCFSST` double DEFAULT NULL,
  `DATADAMOV` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vendapdv`
--

INSERT INTO `vendapdv` (`CACODIGO`, `VDCODIGO`, `DATACANC`, `CODAUTOR`, `DATAHORACUP`, `DATA`, `VENDEDOR`, `CLCODIGO`, `NOMECLIE`, `CGCCLIE`, `CPFCLIE`, `LIMCREBAI`, `LIMCRESEC`, `CODINTERN`, `DESCONTO`, `ACRESCIMO`, `VALVENDA`, `EQUIPAME`, `MSCODIGO`, `MECODIGO`, `DATAAMESA`, `CONFECFSER`, `CONFEECF`, `CONFECOO`, `CONFECER`, `FUCODIGO`, `PERIODO`, `HORARIO`, `ECFSEQUE`, `ECFSERIE`, `ECFMARCA`, `ECFMODELO`, `ECFTIPO`, `SWBVERSAO`, `SWBDTHRGR`, `SWBMFADIC`, `NUMCUPOM`, `QTDPESSOA`, `QTDCUPENT`, `HORAINIC`, `HORAPAGT`, `DAV`, `NUMORCAM`, `NOME`, `ENDERECO`, `TELEFONE`, `DOCUMENTO`, `NUMEROCOO`, `OBS1`, `OBS2`, `OBS3`, `OBS4`, `OBS5`, `OBS6`, `OBS7`, `OBS8`, `KM`, `PLACA`, `BAIXAESTO`, `CLCODPAI`, `FLAGTRANS`, `FLAGTSERV`, `FLAGFINAN`, `FICODIGO`, `SETORUSO`, `FACODIGO`, `CENTCUSTO`, `PASEMBARQUE`, `PASDESTINO`, `PASLINHA`, `PASAGENCIA`, `PASDATA`, `PASHORA`, `PASPOLTRONA`, `PASPLATAFORMA`, `PASTIPOPASSAGEM`, `PASRG`, `PASNOME`, `PASENDERECO`, `PASUFDESTINO`, `PASPERCURSO`, `PASTPVENDA`, `PASCODARD`, `CODAUTOEXT`, `ORIGEM`, `MULTMESAS`, `PAFINDCANC`, `MODELODOC`, `PAFHASHVER`, `PAFHASHCAP`, `VLRBCPIS`, `VALORPIS`, `VLRPISST`, `VLRBCCFS`, `VALORCFS`, `VLRCFSST`, `DATADAMOV`) VALUES
('C1', 1, NULL, NULL, '2018-05-22', '2018-05-22', 1, 0, '', '', '', 0, 0, '', 0, 0, 2.99, 1, '0', 0, '2018-05-22', '', '', 0, 0, 1, 1, '18:52\n', '  ', 'X2', '', '', '', '', NULL, '', 0, 1, NULL, '18:52\n', '18:52\n', 0, '', '', '', '', '', 0, '', '', '', '', '', '', '', '', 0, '', 'S', 0, NULL, NULL, NULL, 0, 'LOJA', NULL, '1', '', '', '', '', '', '', '', '', '', '', '', '', '', 0, 0, 0, '', 'MOVIM', 'N', 'N', '2D', '4.01', '', 0, 0, 0, 0, 0, 0, '2018-05-22'),
('C1', 2, NULL, NULL, '2018-05-22', '2018-05-22', 1, 0, '', '', '', 0, 0, '', 0, 0, 2.99, 1, '0', 0, '2018-05-22', '', '', 0, 0, 1, 1, '19:10\n', '  ', 'X2', '', '', '', '', NULL, '', 0, 1, NULL, '19:10\n', '19:10\n', 0, '', '', '', '', '', 0, '', '', '', '', '', '', '', '', 0, '', 'S', 0, NULL, NULL, NULL, 0, 'LOJA', NULL, '1', '', '', '', '', '', '', '', '', '', '', '', '', '', 0, 0, 0, '', 'MOVIM', 'N', 'N', '2D', '4.01', '', 0, 0, 0, 0, 0, 0, '2018-05-22'),
('C1', 3, NULL, NULL, '2018-05-22', '2018-05-22', 1, 0, '', '', '', 0, 0, '', 0, 0, 2.99, 1, '0', 0, '2018-05-22', '', '', 0, 0, 1, 1, '19:51\n', '  ', 'X2', '', '', '', '', NULL, '', 0, 1, NULL, '19:51\n', '19:51\n', 0, '', '', '', '', '', 0, '', '', '', '', '', '', '', '', 0, '', 'S', 0, NULL, NULL, NULL, 0, 'LOJA', NULL, '1', '', '', '', '', '', '', '', '', '', '', '', '', '', 0, 0, 0, '', 'MOVIM', 'N', 'N', '2D', '4.01', '', 0, 0, 0, 0, 0, 0, '2018-05-22'),
('C1', 4, NULL, NULL, '2018-05-22', '2018-05-22', 1, 0, '', '', '', 0, 0, '', 0, 0, 2.99, 1, '0', 0, '2018-05-22', '', '', 0, 0, 1, 1, '20:13\n', '  ', 'X2', '', '', '', '', NULL, '', 0, 1, NULL, '20:13\n', '20:13\n', 0, '', '', '', '', '', 0, '', '', '', '', '', '', '', '', 0, '', 'S', 0, NULL, NULL, NULL, 0, 'LOJA', NULL, '1', '', '', '', '', '', '', '', '', '', '', '', '', '', 0, 0, 0, '', 'MOVIM', 'N', 'N', '2D', '4.01', '', 0, 0, 0, 0, 0, 0, '2018-05-22');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
