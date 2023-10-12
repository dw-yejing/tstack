package edu.bjtu.netty.core;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;

public class HttpServer {
    public void start(int port) throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup(); //主
        EventLoopGroup workGroup = new NioEventLoopGroup();//从

        try {
            ServerBootstrap bootstrap = new ServerBootstrap(); //创建引导器
            bootstrap.group(bossGroup, workGroup)
                    .channel(NioServerSocketChannel.class) // 推荐 Netty 服务端采用 NioServerSocketChannel 作为 Channel 的类型
                    .localAddress(new InetSocketAddress(port))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline()
                                    .addLast("codec", new HttpServerCodec())// HTTP 编解码
                                    .addLast("compressor", new HttpContentCompressor())// HttpContent 压缩
                                    .addLast("aggregator", new HttpObjectAggregator(65536)) // HTTP 消息聚合
                                    .addLast("handler", new HttpServerHandler());
                        }
                    }).childOption(ChannelOption.SO_KEEPALIVE, true); //	设置为 true 代表启用了 TCP SO_KEEPALIVE 属性，TCP 会主动探测连接状态，即连接保活

            ChannelFuture f = bootstrap.bind().sync();
            System.out.println("Http Server started， Listening on " + port);
            f.channel().closeFuture().sync();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            workGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }


    }

    /**
     * 业务自定义的逻辑处理类:它是入站 ChannelInboundHandler 类型的处理器，负责接收解码后的 HTTP 请求数据，并将请求处理结果写回客户端。
     */
    public class HttpServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
        @Override
        protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest msg) throws Exception {
            Channel channel = ctx.channel(); // 获取通道
            System.out.println(channel.remoteAddress()); // 显示客户端的远程地址
            String content = String.format("Receive http request, uri: %s, method: %s, content: %s%n", msg.uri(), msg.method(), msg.content().toString(CharsetUtil.UTF_8));
            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, Unpooled.wrappedBuffer(content.getBytes()));
            ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
        }
    }

    public static void main(String[] args) throws Exception {
        new HttpServer().start(8088);
    }
}
