import LatencyPill from "./latency-pill";

import List from "../list";

import { Server } from "~/utils/types";

type ServerEntryProps = {
  server: Server;
};

export default function ServerEntry({ server }: ServerEntryProps) {
  return (
    <List.Item layoutId={server.name}>
      {/* Server Icon Wrapper */}
      <div className="relative h-[68px] w-[68px]">
        {/* Server Icon */}
        <img src={server.icon} alt="Server Icon" className="rounded-md" />
        <LatencyPill
          latency={server.latency}
          className="absolute top-0 left-1/2 -translate-x-1/4"
        />
      </div>

      {/* Metadata */}
      <div className="flex flex-col space-y-1">
        {/* Server Name Wrapper */}
        <div className="flex space-x-2">
          <div className="text-white text-xl font-semibold uppercase">
            {server.name}
          </div>
          {/* Player Count */}
          <span className="flex items-center text-white text-[10px] font-semibold bg-brand rounded-full px-2 py-1">
            {server.players} players
          </span>
        </div>

        {/* Server MOTD */}
        <div className="text-white/50 text-xl font-semibold">{server.motd}</div>
      </div>
    </List.Item>
  );
}