PGDMP  1    )                }            concesionaria    17.4    17.4                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                           false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                           false                        0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                           false            !           1262    16720    concesionaria    DATABASE     s   CREATE DATABASE concesionaria WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'pt-BR';
    DROP DATABASE concesionaria;
                     postgres    false            �            1259    16722    veiculos    TABLE     �   CREATE TABLE public.veiculos (
    id integer NOT NULL,
    marca character varying(100) NOT NULL,
    modelo character varying(100) NOT NULL,
    preco numeric(10,2) NOT NULL,
    ano_fabricacao integer NOT NULL
);
    DROP TABLE public.veiculos;
       public         heap r       postgres    false            �            1259    16721    veiculos_id_seq    SEQUENCE     �   CREATE SEQUENCE public.veiculos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.veiculos_id_seq;
       public               postgres    false    218            "           0    0    veiculos_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.veiculos_id_seq OWNED BY public.veiculos.id;
          public               postgres    false    217            �           2604    16725    veiculos id    DEFAULT     j   ALTER TABLE ONLY public.veiculos ALTER COLUMN id SET DEFAULT nextval('public.veiculos_id_seq'::regclass);
 :   ALTER TABLE public.veiculos ALTER COLUMN id DROP DEFAULT;
       public               postgres    false    217    218    218                      0    16722    veiculos 
   TABLE DATA           L   COPY public.veiculos (id, marca, modelo, preco, ano_fabricacao) FROM stdin;
    public               postgres    false    218   (       #           0    0    veiculos_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.veiculos_id_seq', 12, true);
          public               postgres    false    217            �           2606    16727    veiculos veiculos_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.veiculos
    ADD CONSTRAINT veiculos_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.veiculos DROP CONSTRAINT veiculos_pkey;
       public                 postgres    false    218               N   x�3�ɯ�/I�t�/���I�4500�30�4202�2����K�f�e&sZX ���9��R8�9Mz-�b���� �     