package customCode;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.lang.management.RuntimeMXBean;
import java.lang.management.ThreadMXBean;

public class EngineResource {
	
	protected String pid = "";
	protected String host = "";
	protected int threadCount = 0;
	protected double cpuUsage = 0.0d;
	protected long initHeap = 0;
	protected long maxHeap = 0;
	protected long usedHeap = 0;
	protected long committedHeap = 0;
	protected long initNonHeap = 0;
	protected long maxNonHeap = 0;
	protected long usedNonHeap = 0;
	protected long committedNonHeap = 0;

	public EngineResource() {
	}

	public void resourceCheck() throws Exception {
		// TODO Auto-generated method stub
		com.sun.management.OperatingSystemMXBean csmOSMXBean = (com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
		ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
		MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
		RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
		
		String processInfo = runtimeMXBean.getName();
		double cpuUsage = Math.round(csmOSMXBean.getProcessCpuLoad() * 10 * 10) / 10.0;		
// 		둘중 뭘 사용할지는 테스트 후 결정 우선 getPeakThreadCount 사용
//		int threadCount = threadMXBean.getThreadCount();
		int threadCount = threadMXBean.getPeakThreadCount();
		
		MemoryUsage heapMemory = memoryMXBean.getHeapMemoryUsage();
		long initHeap = heapMemory.getInit() / 1024 /1024;
		long maxHeap = heapMemory.getMax() / 1024 / 1024;
		long usedHeap = heapMemory.getUsed() / 1024 / 1024;
		long committedHeap = heapMemory.getCommitted() / 1024 / 1024;
		
		MemoryUsage nonheapMemory = memoryMXBean.getNonHeapMemoryUsage();
		long initNonHeap = nonheapMemory.getInit() / 1024 /1024;
		long maxNonHeap = nonheapMemory.getMax() / 1024 / 1024;
		long usedNonHeap = nonheapMemory.getUsed() / 1024 / 1024;
		long committedNonHeap = nonheapMemory.getCommitted() / 1024 / 1024;
		
		String[] processInfoArray = processInfo.split("@");
		setHost(processInfoArray[1]);
		setPid(processInfoArray[0]);
		setCpuUsage(cpuUsage);
		setThreadCount(threadCount);
		
		setInitHeap(initHeap);
		setMaxHeap(maxHeap);
		setUsedHeap(usedHeap);
		setCommittedHeap(committedHeap);
		
		setInitNonHeap(initNonHeap);
		setMaxNonHeap(maxNonHeap);
		setUsedNonHeap(usedNonHeap);
		setCommittedNonHeap(committedNonHeap);
	}

	public String getPid() {
			return pid;
		}
	public void setPid(String val) {
			pid = val;
		}

	public String getHost() {
			return host;
		}
	public void setHost(String val) {
			host = val;
		}

	public int getThreadCount() {
			return threadCount;
		}
	public void setThreadCount(int val) {
			threadCount = val;
		}

	public double getCpuUsage() {
			return cpuUsage;
		}
	public void setCpuUsage(double val) {
			cpuUsage = val;
		}

	public long getInitHeap() {
			return initHeap;
		}
	public void setInitHeap(long val) {
			initHeap = val;
		}

	public long getMaxHeap() {
			return maxHeap;
		}
	public void setMaxHeap(long val) {
			maxHeap = val;
		}

	public long getUsedHeap() {
			return usedHeap;
		}
	public void setUsedHeap(long val) {
			usedHeap = val;
		}

	public long getCommittedHeap() {
			return committedHeap;
		}
	public void setCommittedHeap(long val) {
			committedHeap = val;
		}

	public long getInitNonHeap() {
			return initNonHeap;
		}
	public void setInitNonHeap(long val) {
			initNonHeap = val;
		}

	public long getMaxNonHeap() {
			return maxNonHeap;
		}
	public void setMaxNonHeap(long val) {
			maxNonHeap = val;
		}

	public long getUsedNonHeap() {
			return usedNonHeap;
		}
	public void setUsedNonHeap(long val) {
			usedNonHeap = val;
		}

	public long getCommittedNonHeap() {
			return committedNonHeap;
		}
	public void setCommittedNonHeap(long val) {
			committedNonHeap = val;
		}
}
