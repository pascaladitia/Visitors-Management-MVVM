-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 17 Nov 2020 pada 14.23
-- Versi server: 10.4.14-MariaDB
-- Versi PHP: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `visitors_management`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `user_email` varchar(40) NOT NULL,
  `user_password` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`user_id`, `user_email`, `user_password`) VALUES
(12, 'pascal@gmail.com', '25d55ad283aa400af464c76d713c07ad'),
(15, 'mirza@gmail.com', '25d55ad283aa400af464c76d713c07ad'),
(17, 'hendri@gmail.com', '25d55ad283aa400af464c76d713c07ad'),
(18, 'adang@gmail.com', '25d55ad283aa400af464c76d713c07ad'),
(19, 'hamudi@gmail.com', '25d55ad283aa400af464c76d713c07ad'),
(20, 'user@gmail.com', '25d55ad283aa400af464c76d713c07ad');

-- --------------------------------------------------------

--
-- Struktur dari tabel `visitors`
--

CREATE TABLE `visitors` (
  `id` int(11) NOT NULL,
  `name` varchar(35) NOT NULL,
  `address` varchar(40) NOT NULL,
  `nohp` int(11) NOT NULL,
  `profession` varchar(35) NOT NULL,
  `visitors` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `visitors`
--

INSERT INTO `visitors` (`id`, `name`, `address`, `nohp`, `profession`, `visitors`) VALUES
(2, 'mirza faturahman', 'sukabumi', 2147483647, 'guru', 'aktif'),
(4, 'Pascal Aditia Muclis', 'Sukabumi', 2147483647, 'Guru', 'Aktif'),
(5, 'Hendriyana', 'Sukabumi', 2147483647, 'Pedagang', 'Nonaktif'),
(6, 'Adang Badru', 'Sukabumi', 8363920, 'Guru', 'Aktif'),
(7, 'Hamudi', 'Sukabumi', 89383783, 'Pengangguran', 'Aktif');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- Indeks untuk tabel `visitors`
--
ALTER TABLE `visitors`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT untuk tabel `visitors`
--
ALTER TABLE `visitors`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
